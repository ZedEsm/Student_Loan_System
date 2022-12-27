package entity.loan;


import entity.Student;
import enums.Grade;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@IdClass(StudentLoanPayID.class)
public class StudentLoanPay {
    @Id
    @ManyToOne
    Student student;

    @Id
    @ManyToOne
    Loan loan;

    @Enumerated(EnumType.STRING)
    Grade grade;

    public StudentLoanPay(Student student, Loan loan, Grade grade) {
        this.student = student;
        this.loan = loan;
        this.grade = grade;
    }
}
