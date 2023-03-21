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
import ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.repository.CourseRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CourseDAOImplTest extends IntegrationTestBase {
    @Autowired
    private CourseRepository courseRepository;

    @Test
    @Order(1)
    public void getAllCourses_ShouldReturnListOfCourses_WhenCallingMethod() {
        assertEquals(Source.coursesWithStudents, courseRepository.findAll());
    }

    @Test
    @Order(3)
    void saveOrUpdate() {
        Course course = Source.coursesWithStudents.get(0);
        Source.coursesWithStudents.remove(0);
        course.setCourseName("New course");
        courseRepository.save(course);
        Source.coursesWithStudents.add(course);
        System.out.println(courseRepository.findById(1));
        assertEquals(Source.coursesWithStudents, courseRepository.findAll());
    }

    @Test
    @Order(2)
    void getCourseById() {
        assertEquals(Optional.of(Source.coursesWithStudents.get(1)), courseRepository.findById(2));
    }
}