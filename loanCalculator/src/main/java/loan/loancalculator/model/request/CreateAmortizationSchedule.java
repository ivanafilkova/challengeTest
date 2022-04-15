package loan.loancalculator.model.request;

public class CreateAmortizationSchedule {
   private double apr;
   private int numberOfPayments;
   private double amount;

    public CreateAmortizationSchedule(double apr, int numberOfPayments, double amount) {
        this.apr = apr;
        this.numberOfPayments = numberOfPayments;
        this.amount = amount;
    }

    public CreateAmortizationSchedule(AmortizationSchedule amortizationSchedule) {
        this.apr = Double.parseDouble(amortizationSchedule.getApr());
        this.numberOfPayments = Integer.parseInt(amortizationSchedule.getNumberOfPayments());
        this.amount = Double.parseDouble(amortizationSchedule.getAmount());
    }

    public double getApr() {
        return apr;
    }

    public void setApr(double apr) {
        this.apr = apr;
    }

    public int getNumberOfPayments() {
        return numberOfPayments;
    }

    public void setNumberOfPayments(int numberOfPayments) {
        this.numberOfPayments = numberOfPayments;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
