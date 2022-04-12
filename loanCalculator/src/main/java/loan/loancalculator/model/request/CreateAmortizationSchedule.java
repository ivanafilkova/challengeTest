package loan.loancalculator.model.request;

public class CreateAmortizationSchedule {
   private double apr;
   private int years;
   private double amount;

    public CreateAmortizationSchedule(double apr, int years, double amount) {
        this.apr = apr;
        this.years = years;
        this.amount = amount;
    }

    public CreateAmortizationSchedule(AmortizationSchedule amortizationSchedule) {
        this.apr = Double.parseDouble(amortizationSchedule.getApr());
        this.years = Integer.parseInt(amortizationSchedule.getYears());
        this.amount = Double.parseDouble(amortizationSchedule.getAmount());
    }

    public double getApr() {
        return apr;
    }

    public void setApr(double apr) {
        this.apr = apr;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
