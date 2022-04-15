package loan.loancalculator.model.request;

public class AmortizationSchedule {
    private String apr;
    private String numberOfPayments;
    private String amount;

    public AmortizationSchedule(String apr, String numberOfPayments, String amount) {
        this.apr = apr;
        this.numberOfPayments = numberOfPayments;
        this.amount = amount;
    }

    public String getApr() {
        return apr;
    }

    public void setApr(String apr) {
        this.apr = apr;
    }

    public String getNumberOfPayments() {
        return numberOfPayments;
    }

    public void setNumberOfPayments(String numberOfPayments) {
        this.numberOfPayments = numberOfPayments;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
