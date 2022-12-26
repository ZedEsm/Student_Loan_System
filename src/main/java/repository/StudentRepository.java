package repository;

import entity.Student;

import javax.persistence.EntityManager;


public class StudentRepository implements IRepository<Student> {
    private static final StudentRepository studentRepository =  new StudentRepository();

    private StudentRepository() {
    }

    public static StudentRepository getInstance() {

        return studentRepository;
    }

    @Override
    public void save(Student student) {
        EntityManager entityManager = DatabaseAccess.getEntityManager().createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(student);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
