package loan.loancalculator.controller;

import loan.loancalculator.entity.Loan;
import loan.loancalculator.entity.Schedule;
import loan.loancalculator.model.request.AmortizationSchedule;
import loan.loancalculator.model.request.CreateAmortizationSchedule;
import loan.loancalculator.model.request.CreateLoanMonthPayment;
import loan.loancalculator.model.response.AmortizationScheduleAnswer;
import loan.loancalculator.model.response.LoanMonthlyPaymentAnswer;
import loan.loancalculator.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class LoanController {

    @Autowired
    LoanService loanService;

    public LoanController() {
    }

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    public LoanService getLoanService() {
        return loanService;
    }

    public void setLoanService(LoanService loanService) {
        this.loanService = loanService;
    }


    @RequestMapping(value = "/calculateLoan", method = RequestMethod.POST)
    public LoanMonthlyPaymentAnswer createLoanMonthlyPayment(@RequestBody CreateLoanMonthPayment model) {
        Loan loanResult = loanService.calculateMonthlyLoan(model);
        return new LoanMonthlyPaymentAnswer(loanResult);
    }

    @RequestMapping(value = "/loan/{id}", method = RequestMethod.GET)
    public LoanMonthlyPaymentAnswer getLoanMonthlyPayment(@PathVariable Long id) {
        Loan loanResult = loanService.getLoanById(id);
        return new LoanMonthlyPaymentAnswer(loanResult);
    }

    @RequestMapping(value = "/loan/{id}", method = RequestMethod.DELETE)
    public LoanMonthlyPaymentAnswer deleteLoanMonthlyPayment(@PathVariable Long id) {
        Loan loanResult = loanService.deleteLoanById(id);
        return new LoanMonthlyPaymentAnswer(loanResult);
    }


    @RequestMapping(value = "/loan/all", method = RequestMethod.GET)
    public Iterable<LoanMonthlyPaymentAnswer> getAllLoans(HttpServletRequest request) {
        List<Loan> list = loanService.getAllLoans();
        List<LoanMonthlyPaymentAnswer> loanResultList = list.stream().map(LoanMonthlyPaymentAnswer::new).collect(Collectors.toList());
        return loanResultList;
    }


    @RequestMapping(value = "/amortization", method = RequestMethod.POST)
    public List<AmortizationScheduleAnswer> createAmortizationSchedule(@RequestBody AmortizationSchedule model) {
        CreateAmortizationSchedule amortizationSchedule = new CreateAmortizationSchedule(model);
        List<Schedule> scheduleList = loanService.outputAmortizationSchedule(amortizationSchedule, model);
        List<AmortizationScheduleAnswer> schedules = scheduleList.stream().map(AmortizationScheduleAnswer::new).collect(Collectors.toList());

        return schedules;
    }

    @RequestMapping(value = "/amortization/all", method = RequestMethod.GET)
    public Iterable<AmortizationScheduleAnswer> getAllAmortizations(HttpServletRequest request) {
        List<Schedule> list = loanService.getAllAmortizations();
        List<AmortizationScheduleAnswer> amortizationResultList = list.stream().map(AmortizationScheduleAnswer::new).collect(Collectors.toList());
        return amortizationResultList;
    }

}
