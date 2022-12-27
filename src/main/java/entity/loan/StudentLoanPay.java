package entity.loan;


import entity.Student;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@IdClass(StudentLoanPayID.class)
public class StudentLoanPay {
    @Id
    @ManyToOne
    Student student;

    @Id
    @ManyToOne
    Loan loan;
}
