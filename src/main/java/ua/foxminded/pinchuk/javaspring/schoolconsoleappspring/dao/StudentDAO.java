package ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.dao;


import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.dao.exception.DAOException;
import ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.bean.Student;

import java.util.List;

public interface StudentDAO {
    void addStudent(Student student);

    List<Student> getAllStudents() throws DAOException;

    void deleteStudentById(int studentId);

    List<Student> getStudentsByCourseId(int courseId);
}
