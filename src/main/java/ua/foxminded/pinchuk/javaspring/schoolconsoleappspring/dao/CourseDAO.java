package ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.dao;

import ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.bean.Course;
import ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.bean.Student;

import java.util.List;
import java.util.Optional;

public interface CourseDAO {
    List<Course> getAllCourses();

    List<Course> getCoursesByStudentId(int studentId);

    void addStudentToCourse(int studentId, int courseId);

    void removeStudentFromCourse(int studentId, int courseId);
}
