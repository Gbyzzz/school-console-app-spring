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
//        when(courseDao.findAllCourses()).thenReturn(Source.courses);
//        when(studentDAO.getStudentsByCourseId(1)).thenReturn(Source.students);
//        when(studentDAO.getStudentsByCourseId(2)).thenReturn(null);
//        assertEquals(Source.coursesWithStudents, courseService.findAllCourses());
    }

    @Test
    void findCourseByStudentId() {
//        when(courseDao.getCoursesByStudentId(1)).thenReturn(Source.courses);
//        assertEquals(Source.courses, courseService.findCourseByStudentId(1));

    }
}