package loan.loancalculator.entity;

import lombok.Data;
import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Data
@Entity
@Table(name="loans")
public class Loan {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    @OneToMany(mappedBy="loan", cascade = CascadeType.REMOVE)
    private List<Schedule> schedules = new LinkedList<>();

    private double loanAmount;


    private double interestRate;

    private int loanYears;

    private double monthlyPayments;

    private double totalInterestPayed;

    public Loan() {
    }

    public Loan(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public int getLoanYears() {
        return loanYears;
    }

    public double getMonthlyPayments() {
        return monthlyPayments;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public void setLoanYears(int loanYears) {
        this.loanYears = loanYears;
    }

    public void setMonthlyPayments(double monthlyPayments) {
        this.monthlyPayments = monthlyPayments;
    }

    public double getTotalInterestPayed() {
        return totalInterestPayed;
    }

    public void setTotalInterestPayed(double totalInterestPayed) {
        this.totalInterestPayed = totalInterestPayed;
    }

    public List<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<Schedule> schedules) {
        this.schedules = schedules;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "id=" + id +
                ", loanAmount=" + loanAmount +
                ", interestRate=" + interestRate +
                ", loanYears=" + loanYears +
                ", monthlyPayments=" + monthlyPayments +
                ", totalInterestPayed=" + totalInterestPayed +
                '}';
    }

}
