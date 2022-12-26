package view;

import entity.Student;
import entity.UserInformation;
import enums.Grade;
import enums.UniversityType;
import service.StudentService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    private static final StudentService STUDENT_SERVICE = StudentService.getInstance();

    public static void printMenu(String[] options) {
        for (String option : options) {
            System.out.println(option);
        }
        System.out.print("Choose your option : ");
    }

    public static void main(String[] args) {
        String[] options = {"1- Sign Up",
//                "2- Option 2",
//                "3- Option 3",
//                "4- Exit",
        };

        int option = 1;
        while (option != 4) {
            printMenu(options);
            try {
                option = scanner.nextInt();
                if (option == 1) {
                    signUp();
                }
            } catch (Exception ex) {
                System.out.println("An unexpected error happened. Please try again");
                scanner.next();
            }

        }

    }

    private static void signUp() throws ParseException {
        System.out.println("First Name: ");
        String firstName = scanner.next();

        System.out.println("Last Name: ");
        String lastName = scanner.next();

        System.out.println("Mother's name: ");
        String motherName = scanner.next();

        System.out.println("Father's name: ");
        String fatherName = scanner.next();

        System.out.println("Birth Certificate: ");
        String birthCertificate = scanner.next();

        System.out.println("National ID: ");
        String nationalID = scanner.next();

        System.out.println("Birthdate: format :yyyy-MM-dd");
        String birthdate = scanner.next();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        Date date = formatter.parse(birthdate);


        System.out.println("Student Number: ");
        String studentNumber = scanner.next();

        System.out.println("University Name: ");
        String universityName = scanner.next();

        System.out.println("University Type: ");
        String universityType = scanner.next();
        UniversityType universityType1 = UniversityType.valueOf(universityType);

        System.out.println("Entry Date: ");
        String entryDate = scanner.next();

        Date date1 = formatter.parse(entryDate);


        System.out.println("Grade: ");
        String grade = scanner.next();
        Grade grade1 = Grade.valueOf(grade);

        System.out.println("password: ");
        String password = scanner.next();
        UserInformation userInformation = new UserInformation(nationalID, password);

        Student student = new Student(userInformation, firstName, lastName, motherName,
                fatherName, birthCertificate, nationalID, date, studentNumber,
                universityName, universityType1, date1, grade1);
        STUDENT_SERVICE.signUp(student);


    }

}
