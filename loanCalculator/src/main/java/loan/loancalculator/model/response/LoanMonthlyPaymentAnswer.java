package loan.loancalculator.model.response;

import loan.loancalculator.entity.Loan;

public class LoanMonthlyPaymentAnswer {

    private double monthlyPayment;
    private double totalInterestPayed;

    public LoanMonthlyPaymentAnswer(double monthlyPayment, double totalInterestPayed) {
        this.monthlyPayment = monthlyPayment;
        this.totalInterestPayed = totalInterestPayed;
    }

    public LoanMonthlyPaymentAnswer(Loan loan) {
        this.monthlyPayment = loan.getMonthlyPayments();
        this.totalInterestPayed = loan.getTotalInterestPayed();
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
