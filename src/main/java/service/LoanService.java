package service;

import entity.loan.TuitionLoan;
import enums.Grade;
import repository.LoanRepository;

public class LoanService {
    private static final LoanService LOAN_SERVICE = new LoanService();;

    private static final LoanRepository LOAN_REPOSITORY = LoanRepository.getInstance();
    private LoanService() {
    }

    public static LoanService getInstance() {
        return LOAN_SERVICE;
    }

    public TuitionLoan takeTuitionLoanByGrade(Grade grade){
       return LOAN_REPOSITORY.takeTuitionLoanByGrade(grade);
    }
}
