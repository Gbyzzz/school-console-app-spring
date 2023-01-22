package ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.service.impl;

import org.springframework.stereotype.Service;
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
        for (Course course : courses) {
            course.setStudents(studentDAO.getStudentsByCourseId(course.getCourseId()));
        }

        return courses;
    }

    @Override
    public List<Course> findCourseByStudentId(int studentId) {
        return courseDAO.getCoursesByStudentId(studentId);
    }

    @Override
    public void addStudentToCourse(int studentId, int courseId) {
        courseDAO.addStudentToCourse(studentId, courseId);
    }

    @Override
    public void removeStudentFromCourse(int studentId, int courseId) {
        courseDAO.removeStudentFromCourse(studentId, courseId);
    }
}
