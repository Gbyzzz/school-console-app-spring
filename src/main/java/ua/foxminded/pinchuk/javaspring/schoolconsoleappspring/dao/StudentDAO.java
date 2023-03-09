package ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.dao;


import ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.bean.Student;

import java.util.List;

public interface StudentDAO {

    Student saveOrUpdate(Student student);

    List<Student> getAllStudents();

    void deleteStudentById(Student student);

    Student getStudentById(int studentId);
}
