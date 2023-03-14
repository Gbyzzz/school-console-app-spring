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

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CourseDAOImplTest extends IntegrationTestBase {
    @Autowired
    private CourseDAO courseDAO;

    @Test
    @Order(1)
    public void getAllCourses_ShouldReturnListOfCourses_WhenCallingMethod() {
        assertEquals(Source.coursesWithStudents, courseDAO.getAllCourses());
    }

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