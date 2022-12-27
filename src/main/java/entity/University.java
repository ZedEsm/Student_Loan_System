//package entity;
//
//import enums.Grade;
//import enums.UniversityType;
//import lombok.*;
//import lombok.experimental.FieldDefaults;
//
//import javax.persistence.*;
//import java.util.Date;
//
//@Entity
//@Getter
//@Setter
//@ToString
//@AllArgsConstructor
//@NoArgsConstructor
//@FieldDefaults(level = AccessLevel.PRIVATE)
//public class University {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id", nullable = false)
//    int id;
//    @Column(nullable = false)
//    String name;
//    @Enumerated(EnumType.STRING)
//    UniversityType universityType;
//    @Temporal(TemporalType.DATE)
//    Date enteringDate;
//    @Enumerated(EnumType.STRING)
//    Grade grade;
//    @Column(nullable = false)
//    int studentNumber;
//}
