package ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.dao;

import ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.bean.Course;

import java.util.List;

public interface CourseDAO {

    List<Course> getAllCourses();

    void saveOrUpdate(Course course);

    Course getCourseById(int courseId);
}