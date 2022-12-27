package view;

import entity.Student;
import entity.UserInformation;

import enums.Grade;
import enums.UniversityType;
import exceptions.InvalidStudentException;
import exceptions.ValidationException;
import service.StudentService;
import util.Validation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    private static final StudentService STUDENT_SERVICE = StudentService.getInstance();

    private static Student student;


    public static void printMenu(String[] options) {
        for (String option : options) {
            System.out.println(option);
        }
        System.out.print("Choose your option : ");
    }

    public static void main(String[] args) {
        String[] options = {"1- Sign Up",
                "2- Sign In",
                "3- Exit",
        };

        int option = 1;
        while (option != 3) {
            printMenu(options);
            try {
                option = scanner.nextInt();
                if (option == 1) {
                    signUp();
                } else if (option == 2) {
                    signIn();
                }
            } catch (Exception ex) {
                System.out.println("Please try again");
                scanner.next();
            }

        }

    }

    private static void signIn() {
        System.out.println("User Name: ");
        String userName = scanner.next();

        System.out.println("Password: ");
        String password = scanner.next();

        try {
            student=STUDENT_SERVICE.signIn(userName, password);
            System.out.println("Sign In Successfully");
            loanMenu();
        } catch (InvalidStudentException e) {
            System.out.println(e.getMessage());
        }

    }

    private static void loanMenu() {
        String[] options = {"1- Register for loan",
                "2- Reimbursement",
                "3- Exit",
        };

        int option = 1;
        while (option != 3) {
            printMenu(options);
            option = scanner.nextInt();
            if (option == 1) {
                loanSystem();

            } else if (option == 2) {
                reimbursementSystem();
            }

            scanner.next();
        }

    }

    private static void reimbursementSystem() {

    }


    private static void loanSystem() {
        String[] options = {"1- TuitionLoan",
                "2- EducationLoan",
                "3- HousingLoan",
                "4- Exit",
        };

        int option = 1;
        while (option != 4) {
            printMenu(options);
            option = scanner.nextInt();
            if (option == 1) {
                tuitionLoanSystem();

            } else if (option == 2) {
                educationLoanSystem();
            }
            else if (option == 3) {
                housingLoanSystem();
            }

            scanner.next();
        }
    }

    private static void educationLoanSystem() {

    }

    private static void housingLoanSystem() {

    }

    private static void tuitionLoanSystem() {
        if(!student.getUniversityType().equals(UniversityType.STATE_DAILY)){

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

        try {
            Validation.isValidPassword(password);
            UserInformation userInformation = new UserInformation(nationalID, password);

            Student student = new Student(userInformation, firstName, lastName, motherName,
                    fatherName, birthCertificate, nationalID, date, studentNumber,
                    universityName, universityType1, date1, grade1);
            STUDENT_SERVICE.signUp(student);
        } catch (ValidationException e) {
            System.out.println(e.getMessage());
        }


    }

}
