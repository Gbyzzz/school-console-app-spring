package ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.service;



import org.springframework.stereotype.Service;
import ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.bean.Course;

import java.util.List;

@Service
public interface CourseService {
    List<Course> findAllCourses();

    List<Course> findCourseByStudentId(int studentId);

    void addStudentToCourse(int studentId, int courseId);

    void removeStudentFromCourse(int studentId, int courseId);
}
