package ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.service;


import ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.bean.Student;

import java.util.List;

public interface StudentService {
    void addStudent(Student student);

    List<Student> findAllStudents();

    void deleteStudent(Student studentId);

    Student findStudentById(int studentId);
}
