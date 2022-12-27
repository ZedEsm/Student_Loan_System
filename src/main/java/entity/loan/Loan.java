package entity.loan;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;
    @Column(nullable = false)
    double price;
    @OneToMany(mappedBy = "loan")
    @ToString.Exclude
    List<StudentLoanPay> studentLoanPayList = new ArrayList<>();

    public Loan(double price) {
        this.price = price;
    }
}
