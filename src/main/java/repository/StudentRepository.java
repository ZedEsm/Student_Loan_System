package repository;

import entity.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;


public class StudentRepository implements IRepository<Student> {
    private static final StudentRepository STUDENT_REPOSITORY = new StudentRepository();

    private StudentRepository() {
    }

    public static StudentRepository getInstance() {

        return STUDENT_REPOSITORY;
    }

    @Override
    public void save(Student student) {
        EntityManager entityManager = DatabaseAccess.getEntityManager().createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(student);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public Student checkUserExistence(String userName, String password) {
        EntityManager entityManager = DatabaseAccess.getEntityManager().createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Query query = entityManager.createQuery("from Student s where s.userInformation.userName=:username and s.userInformation.password =:password");
        query.setParameter("username", userName);
        query.setParameter("password", password);
        Student singleResult = (Student) query.getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return singleResult;

    }
}
