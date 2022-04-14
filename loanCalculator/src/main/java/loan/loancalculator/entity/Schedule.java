package loan.loancalculator.entity;

import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Data
@Entity
@Table(name="schedules")
public class Schedule {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;


    @ManyToOne
    private Loan loan;

    private int paymentNum;

    private double curMonthlyPaymentAmount;

    private double curMonthlyPrincipalPaid;

    private double curMonthlyInterest;

    private double curBalance;

    private double totalPayments;

    private double totalInterestPaid;

    public Schedule() {
    }

    public Schedule(long id, Loan loan, Loan loan1, int paymentNum, double curMonthlyPaymentAmount, double curMonthlyPrincipalPaid, double curMonthlyInterest, double curBalance, double totalPayments, double totalInterestPaid) {
        this.id = id;
        this.loan = loan;
        this.loan = loan1;
        this.paymentNum = paymentNum;
        this.curMonthlyPaymentAmount = curMonthlyPaymentAmount;
        this.curMonthlyPrincipalPaid = curMonthlyPrincipalPaid;
        this.curMonthlyInterest = curMonthlyInterest;
        this.curBalance = curBalance;
        this.totalPayments = totalPayments;
        this.totalInterestPaid = totalInterestPaid;
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

    public double getCurMonthlyPrincipalPaid() {
        return curMonthlyPrincipalPaid;
    }

    public void setCurMonthlyPrincipalPaid(double curMonthlyPrincipalPaid) {
        this.curMonthlyPrincipalPaid = curMonthlyPrincipalPaid;
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

    public Loan getLoan() {
        return loan;
    }

    public void setLoan(Loan loan) {
        this.loan = loan;
    }


}
