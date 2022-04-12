package loan.loancalculator.model.request;

public class AmortizationSchedule {
    private String apr;
    private String years;
    private String amount;

    public AmortizationSchedule(String apr, String years, String amount) {
        this.apr = apr;
        this.years = years;
        this.amount = amount;
    }

    public String getApr() {
        return apr;
    }

    public void setApr(String apr) {
        this.apr = apr;
    }

    public String getYears() {
        return years;
    }

    public void setYears(String years) {
        this.years = years;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
