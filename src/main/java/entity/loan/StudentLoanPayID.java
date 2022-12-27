package entity.loan;

import entity.Student;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudentLoanPayID implements Serializable {
    Student student;
    Loan loan;
}
