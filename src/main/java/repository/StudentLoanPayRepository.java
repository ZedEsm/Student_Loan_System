package repository;

import entity.loan.StudentLoanPay;

import javax.persistence.EntityManager;

public class StudentLoanPayRepository implements IRepository<StudentLoanPay> {
    private static final StudentLoanPayRepository STUDENT_LOAN_PAY_REPOSITORY = new StudentLoanPayRepository();
    ;

    private StudentLoanPayRepository() {
    }

    public static StudentLoanPayRepository getInstance() {

        return STUDENT_LOAN_PAY_REPOSITORY;
    }

    @Override
    public void save(StudentLoanPay studentLoanPay) {
        EntityManager entityManager = DatabaseAccess.getEntityManager().createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(studentLoanPay);
        entityManager.getTransaction().commit();
        entityManager.close();

    }

    @Override
    public void update(StudentLoanPay studentLoanPay) {

    }
}
