package entity.loan;

import enums.Grade;
import lombok.*;

import javax.persistence.*;


@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
@Entity
public class TuitionLoan extends Loan {

    @Column(unique = true)
    @Enumerated(EnumType.STRING)
    Grade grade;

    public TuitionLoan(double price, Grade grade) {
        super(price);
        this.grade = grade;
    }
}
