package loan.loancalculator.model.response;

import loan.loancalculator.entity.Schedule;

public class AmortizationScheduleAnswer {

            long id;
            int paymentNum;
            double curMonthlyPaymentAmount;
            double curMonthlyPrincipalPaid;
            double curMonthlyInterest;
            double curBalance;
            double totalPayments;
            double totalInterestPaid;

    public AmortizationScheduleAnswer(long id, int paymentNum, double curMonthlyPaymentAmount, double curMonthlyPrincipalPaid, double curMonthlyInterest, double curBalance, double totalPayments, double totalInterestPaid) {
        this.id = id;
        this.paymentNum = paymentNum;
        this.curMonthlyPaymentAmount = curMonthlyPaymentAmount;
        this.curMonthlyPrincipalPaid = curMonthlyPrincipalPaid;
        this.curMonthlyInterest = curMonthlyInterest;
        this.curBalance = curBalance;
        this.totalPayments = totalPayments;
        this.totalInterestPaid = totalInterestPaid;
    }

    public AmortizationScheduleAnswer(Schedule schedule) {
        this.id = schedule.getId();
        this.paymentNum = schedule.getPaymentNum();
        this.curMonthlyPaymentAmount = schedule.getCurMonthlyPaymentAmount();
        this.curMonthlyPrincipalPaid = schedule.getCurMonthlyPrincipalPaid();
        this.curMonthlyInterest = schedule.getCurMonthlyInterest();
        this.curBalance = schedule.getCurBalance();
        this.totalPayments = schedule.getTotalPayments();
        this.totalInterestPaid = schedule.getTotalInterestPaid();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getPaymentNum() {
        return paymentNum;
    }

    public void setPaymentNum(int paymentNum) {
        this.paymentNum = paymentNum;
    }

    public double getCurMonthlyPaymentAmount() {
        return curMonthlyPaymentAmount;
    }

    public void setCurMonthlyPaymentAmount(double curMonthlyPaymentAmount) {
        this.curMonthlyPaymentAmount = curMonthlyPaymentAmount;
    }

    public double getCurMonthlyInterest() {
        return curMonthlyInterest;
    }

    public void setCurMonthlyInterest(double curMonthlyInterest) {
        this.curMonthlyInterest = curMonthlyInterest;
    }

    public double getCurBalance() {
        return curBalance;
    }

    public void setCurBalance(double curBalance) {
        this.curBalance = curBalance;
    }

    public double getTotalPayments() {
        return totalPayments;
    }

    public void setTotalPayments(double totalPayments) {
        this.totalPayments = totalPayments;
    }

    public double getTotalInterestPaid() {
        return totalInterestPaid;
    }

    public void setTotalInterestPaid(double totalInterestPaid) {
        this.totalInterestPaid = totalInterestPaid;
    }

    public double getCurMonthlyPrincipalPaid() {
        return curMonthlyPrincipalPaid;
    }

    public void setCurMonthlyPrincipalPaid(double curMonthlyPrincipalPaid) {
        this.curMonthlyPrincipalPaid = curMonthlyPrincipalPaid;
    }
}
