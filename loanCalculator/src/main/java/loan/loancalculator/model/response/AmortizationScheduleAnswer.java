package loan.loancalculator.model.response;

public class AmortizationScheduleAnswer {
            int paymentNum;
            double curMonthlyPaymentAmount;
            double curMonthlyPrincipalPaid;
            double curMonthlyInterest;
            double curBalance;
            double totalPayments;
            double totalInterestPaid;

    public AmortizationScheduleAnswer(int paymentNum, double curMonthlyPaymentAmount, double curMonthlyPrincipalPaid, double curMonthlyInterest, double curBalance, double totalPayments, double totalInterestPaid) {
        this.paymentNum = paymentNum;
        this.curMonthlyPaymentAmount = curMonthlyPaymentAmount;
        this.curMonthlyPrincipalPaid = curMonthlyPrincipalPaid;
        this.curMonthlyInterest = curMonthlyInterest;
        this.curBalance = curBalance;
        this.totalPayments = totalPayments;
        this.totalInterestPaid = totalInterestPaid;
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
