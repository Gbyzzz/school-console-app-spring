package ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.dao;


import ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.bean.Student;

import java.util.List;

public interface StudentDAO {

    boolean checkIfTableExists();

    void createTable();

    void saveAll(List<Student> students);

    void addStudent(Student student);

    List<Student> getAllStudents();

    void deleteStudentById(int studentId);

    List<Student> getStudentsByCourseId(int courseId);


}
