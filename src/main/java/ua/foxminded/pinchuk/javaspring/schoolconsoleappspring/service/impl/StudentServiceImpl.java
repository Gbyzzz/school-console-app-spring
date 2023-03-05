package ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
    @Transactional
    public void addStudent(Student student) {
        studentDAO.saveOrUpdate(student);
    }

    @Override
    public List<Student> findAllStudents() {
        return studentDAO.getAllStudents();
    }

    @Override
    @Transactional
    public void deleteStudent(Student student) {
        studentDAO.deleteStudentById(student);
    }

    @Override
    public Student findStudentById(int studentId) {
        return studentDAO.getStudentById(studentId);
    }


}
