package loan.loancalculator.model.response;

import loan.loancalculator.entity.Loan;

public class LoanMonthlyPaymentAnswer {

    private long id;
    private double monthlyPayment;
    private double totalInterestPayed;

    public LoanMonthlyPaymentAnswer(long id, double monthlyPayment, double totalInterestPayed) {
        this.id = id;
        this.monthlyPayment = monthlyPayment;
        this.totalInterestPayed = totalInterestPayed;
    }


    public LoanMonthlyPaymentAnswer(Loan loan) {
        this.id = loan.getId();
        this.monthlyPayment = loan.getMonthlyPayments();
        this.totalInterestPayed = loan.getTotalInterestPayed();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setMonthlyPayment(double monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    public double getTotalInterestPayed() {
        return totalInterestPayed;
    }

    public void setTotalInterestPayed(double totalInterestPayed) {
        this.totalInterestPayed = totalInterestPayed;
    }
}
