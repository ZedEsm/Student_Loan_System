package view;

import entity.Student;
import entity.UserInformation;

import entity.loan.Loan;
import entity.loan.StudentLoanPay;
import entity.loan.TuitionLoan;
import enums.Grade;
import enums.UniversityType;
import exceptions.InappropriateLoanRequest;
import exceptions.InvalidStudentException;
import exceptions.ValidationException;
import service.LoanService;
import service.StudentLoanPayService;
import service.StudentService;
import util.Validation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    private static final StudentService STUDENT_SERVICE = StudentService.getInstance();

    private static final StudentLoanPayService STUDENT_LOAN_PAY_SERVICE = StudentLoanPayService.getInstance();

    private static final LoanService LOAN_SERVICE = LoanService.getInstance();

    private static final Loan[] LOANS = new Loan[16];
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
            student = STUDENT_SERVICE.signIn(userName, password);
            System.out.println("Sign In Successfully");
            loanMenu();
        } catch (InvalidStudentException e) {
            System.out.println(e.getMessage());
        }

    }

    private static void loanMenu() {
//        loanLst();
//        addLoans();
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
                try {
                    tuitionLoanSystem();
                } catch (InappropriateLoanRequest e) {
                    System.out.println(e.getMessage());
                }

            } else if (option == 2) {
                educationLoanSystem();
            } else if (option == 3) {
                housingLoanSystem();
            }

            scanner.next();
        }
    }

    private static void educationLoanSystem() {

    }

    private static void housingLoanSystem() {

    }

    private static void tuitionLoanSystem() throws InappropriateLoanRequest {


        // if(!student.getUniversityType().equals(UniversityType.STATE_DAILY)){

        TuitionLoan tuitionLoan = LOAN_SERVICE.takeTuitionLoanByGrade(student.getGrade());
        StudentLoanPay studentLoanPay = new StudentLoanPay(student, tuitionLoan, student.getGrade());
        studentLoanPay.setLoan(tuitionLoan);
        studentLoanPay.setStudent(student);
        studentLoanPay.setGrade(student.getGrade());
        System.out.println(studentLoanPay);
        STUDENT_LOAN_PAY_SERVICE.save(studentLoanPay);

//        }
//        else {
//            throw new InappropriateLoanRequest("No Loans Are Granted To This University");
//        }

    }

    private static void loanLst() {
        //TuitionLoan
        LOANS[0] = new TuitionLoan(1300000, Grade.ASSOCIATE_DEGREE);
        LOANS[1] = new TuitionLoan(1300000, Grade.CONTINUES_BACHELOR_DEGREE);
        LOANS[2] = new TuitionLoan(1300000, Grade.DISCONTINUES_BACHELOR_DEGREE);
        LOANS[3] = new TuitionLoan(2600000, Grade.CONTINUES_MASTER);
        LOANS[4] = new TuitionLoan(2600000, Grade.CONTINUES_PHD);
        LOANS[5] = new TuitionLoan(2600000, Grade.DISCONTINUES_MASTER);
        LOANS[6] = new TuitionLoan(2600000, Grade.PROFESSIONAL_DOCTORATE);
        LOANS[7] = new TuitionLoan(65000000, Grade.PROFESSIONAL_DOCTORATE);
        //HousingLoan
//        LOANS[8] = new HousingLoan();
//        LOANS[9] = new HousingLoan();
//        LOANS[10] = new HousingLoan();
//        LOANS[11] = new HousingLoan();
//        LOANS[12] = new HousingLoan();
//        LOANS[13] = new HousingLoan();
//        LOANS[14] = new HousingLoan();
//        LOANS[15] = new HousingLoan();


    }

    private static void addLoans() {
        LOAN_SERVICE.addLoan(Main.LOANS);
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
