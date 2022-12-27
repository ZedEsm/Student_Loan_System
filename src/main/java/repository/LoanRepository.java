package repository;

import entity.Student;
import entity.loan.Loan;
import entity.loan.TuitionLoan;
import enums.Grade;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

public class LoanRepository implements IRepository<Loan> {
    private static final LoanRepository LOAN_REPOSITORY = new LoanRepository();

    private LoanRepository() {
    }

    public static LoanRepository getInstance() {

        return LOAN_REPOSITORY;
    }

    @Override
    public void save(Loan loan) {
        EntityManager entityManager = DatabaseAccess.getEntityManager().createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(loan);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void update(Loan loan) {

    }

    public TuitionLoan takeTuitionLoanByGrade(Grade grade) {
        EntityManager entityManager = DatabaseAccess.getEntityManager().createEntityManager();
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("from Loan t where t.grade=:grade");
        query.setParameter("grade", grade);
        TuitionLoan tuitionLoan = (TuitionLoan) query.getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return tuitionLoan;
    }

}
