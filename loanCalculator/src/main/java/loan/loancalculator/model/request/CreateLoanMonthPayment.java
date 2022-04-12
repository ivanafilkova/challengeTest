package loan.loancalculator.model.request;

public class CreateLoanMonthPayment {

    private String loanAmount;

    private String interestRate;

    private String loanYears;

    private  String time_type;

    public CreateLoanMonthPayment(String loanAmount, String interestRate, String loanYears, String time_type) {
        this.loanAmount = loanAmount;
        this.interestRate = interestRate;
        this.loanYears = loanYears;
        this.time_type = time_type;
    }

    public String getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(String loanAmount) {
        this.loanAmount = loanAmount;
    }

    public String getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(String interestRate) {
        this.interestRate = interestRate;
    }

    public String getLoanYears() {
        return loanYears;
    }

    public void setLoanYears(String loanYears) {
        this.loanYears = loanYears;
    }

    public String getTime_type() {
        return time_type;
    }

    public void setTime_type(String time_type) {
        this.time_type = time_type;
    }
}
