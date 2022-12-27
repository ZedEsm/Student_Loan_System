package entity;

import entity.loan.StudentLoanPay;
import enums.Grade;
import enums.UniversityType;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;
    @OneToOne(cascade = CascadeType.ALL)
    UserInformation userInformation;
    @Column(nullable = false)
    String firstName;
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
    @Column(nullable = false)
    String universityName;
    @Enumerated(EnumType.STRING)
    UniversityType universityType;
    @Temporal(value = TemporalType.DATE)
    Date entryDate;
    @Enumerated(EnumType.STRING)
    Grade grade;

    @OneToMany(mappedBy = "student", fetch = FetchType.EAGER)
    List<StudentLoanPay> studentLoanPayList=new ArrayList<>();

    public Student(UserInformation userInformation, String firstName, String lastName, String motherName, String fatherName, String birthCertificate, String nationalID, Date birthdate, String studentNumber, String universityName, UniversityType universityType, Date entryDate, Grade grade) {
        this.userInformation = userInformation;
        this.firstName = firstName;
        this.lastName = lastName;
        this.motherName = motherName;
        this.fatherName = fatherName;
        this.birthCertificate = birthCertificate;
        this.nationalID = nationalID;
        this.birthdate = birthdate;
        this.studentNumber = studentNumber;
        this.universityName = universityName;
        this.universityType = universityType;
        this.entryDate = entryDate;
        this.grade = grade;
    }
}
