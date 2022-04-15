package loan.loancalculator.service;
import javassist.NotFoundException;
import loan.loancalculator.entity.Loan;
import loan.loancalculator.entity.Schedule;
import loan.loancalculator.model.request.AmortizationSchedule;
import loan.loancalculator.model.request.CreateAmortizationSchedule;
import loan.loancalculator.model.request.CreateLoanMonthPayment;
import loan.loancalculator.model.response.AmortizationScheduleAnswer;
import loan.loancalculator.repository.LoanRepository;
import loan.loancalculator.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.lang.Math;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class LoanService {

    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private ScheduleRepository scheduleRepository;

    private static final double MONTHLY_INTEREST_DIVISOR = 12d * 100d;

    public LoanService(LoanRepository loanRepository, ScheduleRepository scheduleRepository) {
        this.loanRepository = loanRepository;
        this.scheduleRepository = scheduleRepository;
    }

    public Loan getLoanById(Long id){
       return loanRepository.findById(id).get();
    }

    public List<Loan> getAllLoans() {
        List<Loan> result = new ArrayList<>();
        loanRepository.findAll().forEach(result::add);
        return result;
    }

    public Loan calculateMonthlyLoan(CreateLoanMonthPayment model){
        double principal;
        double intRate;
        int numYears;
        final int payPerYear = 12;

        double result = 0.0;
        double numer;
        double denom;
        double b, e;
        String amountStr = model.getLoanAmount();
        String periodStr = model.getLoanYears();
        String rateStr = model.getInterestRate();
        try
        {
            if(amountStr.length() != 0 &&
                    periodStr.length() != 0 &&
                    rateStr.length() != 0) {
                principal = Double.parseDouble(amountStr);
                numYears = Integer.parseInt(periodStr);
                intRate = Double.parseDouble(rateStr) / 100;

                numer = intRate * principal / payPerYear;
                String type = "year";
                if(model.getTime_type().equals(type)){
                    e = -(payPerYear * numYears);
                }
                else {
                    e = -numYears;
                }
                b = (intRate / payPerYear) + 1.0;
                denom = 1.0 - Math.pow(b, e);
                result = numer / denom;
                Loan loan = new Loan();
                loan.setLoanAmount(principal);
                loan.setLoanYears(numYears);
                loan.setInterestRate(intRate);
                loan.setMonthlyPayments(result);
                loan.setTotalInterestPayed(0.0);
                loanRepository.save(loan);
                return loan;
            }
        } catch (NumberFormatException exc)
        {
            System.out.println("Invalid Data");
        }
        return null;
    }

    public Loan deleteLoanById(Long id) {
            Loan delete_found = loanRepository.findById(id).orElseThrow(NoSuchElementException::new);
            if (delete_found != null)
                loanRepository.deleteById(id);
            return delete_found;
        }


    public List<Schedule> getAllAmortizations() {
        List<Schedule> result = new ArrayList<>();
        scheduleRepository.findAll().forEach(result::add);
        return result;
    }

    /**
     * The first column identifies the payment number.
     * The second column contains the amount of the payment.
     * The third column shows the amount paid to interest.
     * The fourth column has the current balance.  The total payment amount and
     * the interest paid fields.
     */
    public List<Schedule> outputAmortizationSchedule(CreateAmortizationSchedule createAmortizationSchedule, AmortizationSchedule amortizationSchedule) {
        long amountBorrowed = Math.round(createAmortizationSchedule.getAmount());
        long balance = amountBorrowed;
        int paymentNumber = 0;
        long totalPayments = 0;
        long totalInterestPaid = 0;
        long curMonthlyInterest = 0;
        long curPayoffAmount = 0;
        long curMonthlyPaymentAmount= 0;
        long curMonthlyPrincipalPaid = 0;
        long curBalance =0;
        int initialTermMonths =  createAmortizationSchedule.getNumberOfPayments();
        List<Schedule> schedules = new ArrayList<>();

        final int maxNumberOfPayments = initialTermMonths;
        CreateLoanMonthPayment createLoanMonthPayment = new CreateLoanMonthPayment(Double.toString(amountBorrowed), amortizationSchedule.getApr(), amortizationSchedule.getNumberOfPayments(), "month");

        Loan monthlyLoan = calculateMonthlyLoan (createLoanMonthPayment);
        double monthlyLoanPayments = monthlyLoan.getMonthlyPayments();

        while ((balance > 0) && (paymentNumber <= maxNumberOfPayments)) {

            curMonthlyInterest = calculateMonthlyInterest(balance, createAmortizationSchedule.getApr());

            curPayoffAmount = calculateCurrentPayOffAmount(balance,
                    curMonthlyInterest);

            curMonthlyPaymentAmount = Math.min((long) monthlyLoanPayments, curPayoffAmount);

            // it's possible that the calculated monthlyPaymentAmount is 0,
            // or the monthly payment only covers the interest payment (no principal)

            if ((paymentNumber == maxNumberOfPayments) &&
                    ((curMonthlyPaymentAmount == 0) ||
                            (curMonthlyPaymentAmount == curMonthlyInterest))) {
                curMonthlyPaymentAmount = curPayoffAmount;
            }

            curMonthlyPrincipalPaid = calculateCurrentMonthlyPrincipalPaid
                    (curMonthlyPaymentAmount, curMonthlyInterest);

            curBalance = calculateCurrentBalance(balance,
                    curMonthlyPrincipalPaid);

            totalPayments += curMonthlyPaymentAmount;
            totalInterestPaid += curMonthlyInterest;

            balance = curBalance;
            Schedule schedule = new Schedule();
            schedule.setPaymentNum(paymentNumber);
            schedule.setCurMonthlyPaymentAmount(curMonthlyPaymentAmount);
            schedule.setCurMonthlyPrincipalPaid(curMonthlyPrincipalPaid);
            schedule.setCurMonthlyInterest(curMonthlyInterest);
            schedule.setCurBalance(curBalance);
            schedule.setTotalPayments(totalPayments);
            schedule.setTotalInterestPaid(totalInterestPaid);
            schedule.setLoan(monthlyLoan);
            scheduleRepository.save(schedule);
            schedules.add(schedule);
            paymentNumber++;

        }
        return schedules;
    }

    public long calculateMonthlyInterest(long balance, double apr) {
        double monthlyInterest = apr / MONTHLY_INTEREST_DIVISOR;
        return Math.round(((double) balance) * monthlyInterest);
    }

    public long calculateCurrentPayOffAmount(long balance,
                                             long curMonthlyInterest) {
        return balance + curMonthlyInterest;
    }

    public long calculateCurrentMonthlyPrincipalPaid(
            long currentMonthlyPaymentAmount, long currentMonthlyInterest) {
        return currentMonthlyPaymentAmount - currentMonthlyInterest;
    }

    public long calculateCurrentBalance(long balance,
                                        long currentMontlyPrincipalPaid) {
        return balance - currentMontlyPrincipalPaid;
    }

}









