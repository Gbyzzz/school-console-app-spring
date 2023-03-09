package ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.dao.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.IntegrationTestBase;
import ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.Source;
import ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.bean.Course;
import ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.dao.CourseDAO;
import ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.dao.StudentDAO;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CourseDAOImplTest extends IntegrationTestBase {
    @Autowired
    private CourseDAO courseDAO;
    @Autowired
    private StudentDAO studentDAO;

    @Test
    @Order(1)
    public void getAllCourses_ShouldReturnListOfCourses_WhenCallingMethod() {
        assertEquals(Source.coursesWithStudents, courseDAO.getAllCourses());
    }

//    @ParameterizedTest
//    @MethodSource("ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.Source#provideCoursesByStudent")
//    public void getCoursesByStudentId_ShouldReturnListOfCourses_WhenCallingMethod(List<Course> expected, int id) {
//        assertEquals(courseDAO.getCourseById(id), expected);
//    }
//
//    @ParameterizedTest
//    @Order(2)
//    @MethodSource("ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.Source#provideStudents
//    void addStudentToCourse(List<Student> expected) {
//        Student student = new Student(2, "Jeremy", "Brown", Source.group);
//        expected.add(student);
//        courseDAO.addStudentToCourse(2, 2);
//        assertEquals(expected, studentDAO.getStudentsByCourseId(2));
//    }
//
//    @ParameterizedTest
//    @Order(1)
//    @MethodSource("ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.Source#provideStudents")
//    void removeStudentFromCourse(List<Student> expected) {
//        expected.remove(1);
//        courseDAO.removeStudentFromCourse(2, 2);
//        assertEquals(expected, studentDAO.getStudentsByCourseId(2));
//    }



    @Test
    @Order(3)
    void saveOrUpdate() {
        Course course = Source.coursesWithStudents.get(0);
        course.setCourseName("New course");
        courseDAO.saveOrUpdate(course);
        System.out.println(courseDAO.getCourseById(1));
        assertEquals(Source.coursesWithStudents, courseDAO.getAllCourses());
    }

    @Test
    @Order(2)
    void getCourseById() {
        assertEquals(Source.coursesWithStudents.get(1), courseDAO.getCourseById(2));
    }
}