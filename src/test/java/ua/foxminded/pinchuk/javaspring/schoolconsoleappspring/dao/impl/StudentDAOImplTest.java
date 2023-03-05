package ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.dao.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.IntegrationTestBase;
import ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.Source;
import ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.bean.Student;
import ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.dao.StudentDAO;


import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
class StudentDAOImplTest extends IntegrationTestBase {
    @Autowired
    private StudentDAO studentDAO;

    @ParameterizedTest
    @Order(3)
    @MethodSource("ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.Source#provideStudents")
    void addStudent(List<Student> expected) {
        Student student = new Student(3, "Sam", "Green", Source.group);
        expected.add(student);
        studentDAO.saveOrUpdate(student);
        assertEquals(expected, studentDAO.getAllStudents());
    }

    @ParameterizedTest
    @Order(2)
    @MethodSource("ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.Source#provideStudents")
    void getAllStudents(List<Student> expected) {
        assertEquals(expected, studentDAO.getAllStudents());
    }

    @ParameterizedTest
    @Order(4)
    @MethodSource("ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.Source#provideStudents")
    void deleteStudentById(List<Student> expected) {
//        studentDAO.deleteStudentById(3);
        expected.remove(2);
        assertEquals(expected, studentDAO.getAllStudents());
    }

    @ParameterizedTest
    @Order(1)
    @MethodSource("ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.Source#provideGetStudentsByCourseId")
    void getStudentsByCourseId(List<Student> students, int courseId ) {
//        assertEquals(students, studentDAO.getStudentsByCourseId(courseId));
    }
}