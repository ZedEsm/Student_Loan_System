package service;

import entity.loan.StudentLoanPay;
import repository.StudentLoanPayRepository;

public class StudentLoanPayService {
    private static final StudentLoanPayService STUDENT_LOAN_PAY_SERVICE = new StudentLoanPayService();;

    private static final StudentLoanPayRepository STUDENT_LOAN_PAY_REPOSITORY = StudentLoanPayRepository.getInstance();
    private StudentLoanPayService() {
    }

    public static StudentLoanPayService getInstance() {

        return STUDENT_LOAN_PAY_SERVICE;
    }

    public void save(StudentLoanPay studentLoanPay){
        STUDENT_LOAN_PAY_REPOSITORY.save(studentLoanPay);
    }

}
