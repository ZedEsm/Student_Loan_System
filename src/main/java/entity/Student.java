package entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    @Column(nullable = false)
    String FirstName;
    @Column(nullable = false)
    String lastName;
    @Column(nullable = false)
    String motherName;
    @Column(nullable = false)
    String fatherName;
    @Column(nullable = false)
    String birthCertificate;
    @Column(nullable = false)
    String nationalID;
    @Column(nullable = false)
    Date birthdate;
    @Column(nullable = false)
    String studentNumber;
}
