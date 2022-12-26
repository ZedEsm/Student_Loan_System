package service;


import entity.Student;
import repository.StudentRepository;

public class StudentService {
    private static final StudentService studentService = new StudentService();;

    private static final StudentRepository STUDENT_REPOSITORY = StudentRepository.getInstance();
    private StudentService() {
    }

    public static StudentService getInstance() {

        return studentService;
    }

    public void signUp(Student student){
        STUDENT_REPOSITORY.save(student);
    }

}
