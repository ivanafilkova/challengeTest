package loan.loancalculator.entity;

import lombok.Data;
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

}
