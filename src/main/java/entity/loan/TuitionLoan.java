package entity.loan;

import enums.Grade;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
public class TuitionLoan extends Loan{
    @Enumerated(EnumType.STRING)
    Grade grade;
}
