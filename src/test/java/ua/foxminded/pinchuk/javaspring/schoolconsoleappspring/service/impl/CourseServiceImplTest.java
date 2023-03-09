package ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.service.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.Source;
import ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.dao.CourseDAO;
import ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.dao.StudentDAO;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = {CourseServiceImpl.class})
class CourseServiceImplTest {

    @MockBean
    CourseDAO courseDao;

    @MockBean
    StudentDAO studentDAO;

    @Autowired
    CourseServiceImpl courseService;

    @Test
    void findAllCourses() {
        when(courseDao.getAllCourses()).thenReturn(Source.coursesWithStudents);
        assertEquals(Source.coursesWithStudents, courseService.findAllCourses());
    }

}


