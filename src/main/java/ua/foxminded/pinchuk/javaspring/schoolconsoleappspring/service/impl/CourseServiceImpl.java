package ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.service.impl;

import org.springframework.stereotype.Service;
import ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.bean.Student;
import ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.dao.CourseDAO;
import ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.dao.StudentDAO;
import ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.bean.Course;
import ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.service.CourseService;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseDAO courseDAO;
    private final StudentDAO studentDAO;

    public CourseServiceImpl(CourseDAO courseDAO, StudentDAO studentDAO) {
        this.courseDAO = courseDAO;
        this.studentDAO = studentDAO;
    }

    @Override
    public List<Course> findAllCourses() {
        List<Course> courses = courseDAO.getAllCourses();
        return courses;
    }

    @Override
    public void saveOrUpdate(Course course) {
        courseDAO.saveOrUpdate(course);
    }

    @Override
    public void removeStudentFromCourse(Student student, Course course) {
        course.getStudents().remove(student);
        courseDAO.saveOrUpdate(course);
    }

    @Override
    public Course findCourseById(int courseId) {
        return courseDAO.getCourseById(courseId);
    }
}
