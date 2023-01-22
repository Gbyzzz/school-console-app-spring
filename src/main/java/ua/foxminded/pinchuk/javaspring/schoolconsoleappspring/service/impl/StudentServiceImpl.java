package ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.service.impl;

import org.springframework.stereotype.Service;
import ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.bean.Student;
import ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.dao.StudentDAO;
import ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.service.StudentService;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentDAO studentDAO;

    public StudentServiceImpl(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @Override
    public void addStudent(Student student) {
        studentDAO.addStudent(student);
    }

    @Override
    public List<Student> findAllStudents() {
        return studentDAO.getAllStudents();
    }

    @Override
    public void deleteStudentById(int studentId) {
        studentDAO.deleteStudentById(studentId);
    }

    @Override
    public List<Student> findStudentsByCourse(int courseId) {
        return studentDAO.getStudentsByCourseId(courseId);
    }

}
