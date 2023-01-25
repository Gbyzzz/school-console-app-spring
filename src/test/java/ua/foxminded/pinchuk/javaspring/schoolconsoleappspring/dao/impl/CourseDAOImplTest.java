package ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.dao.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.IntegrationTestBase;
import ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.Source;
import ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.bean.Course;
import ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.bean.Student;
import ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.dao.CourseDAO;
import ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.dao.StudentDAO;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
class CourseDAOImplTest extends IntegrationTestBase {
    @Autowired
    private CourseDAO courseDAO;
    @Autowired

    private StudentDAO studentDAO;

    @Test
    public void getAllCourses_ShouldReturnListOfCourses_WhenCallingMethod() {
        assertEquals(Source.courses, courseDAO.getAllCourses());
    }

    @ParameterizedTest
    @MethodSource("ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.Source#provideCoursesByStudent")
    public void getCoursesByStudentId_ShouldReturnListOfCourses_WhenCallingMethod(List<Course> expected, int id) {
        assertEquals(courseDAO.getCoursesByStudentId(id), expected);
    }

    @ParameterizedTest
    @Order(2)
    @MethodSource("ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.Source#provideStudents")
    void addStudentToCourse(List<Student> expected) {
        Student student = new Student(2, "Jeremy", "Brown", Source.group);
        expected.add(student);
        courseDAO.addStudentToCourse(2, 2);
        assertEquals(expected, studentDAO.getStudentsByCourseId(2));
    }

    @ParameterizedTest
    @Order(1)
    @MethodSource("ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.Source#provideStudents")
    void removeStudentFromCourse(List<Student> expected) {
        expected.remove(1);
        courseDAO.removeStudentFromCourse(2, 2);
        assertEquals(expected, studentDAO.getStudentsByCourseId(2));
    }

}