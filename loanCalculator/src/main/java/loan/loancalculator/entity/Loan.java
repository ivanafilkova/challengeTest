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


}
