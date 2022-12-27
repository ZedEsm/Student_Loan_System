package service;


import entity.Student;
import exceptions.InvalidStudentException;
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

    public Student signIn(String userName, String password) throws InvalidStudentException {
        Student student = STUDENT_REPOSITORY.checkUserExistence(userName, password);
        if(student!=null){
            return student;
        }
        throw new InvalidStudentException("Student with this username or password doesn't exist");

    }
}
