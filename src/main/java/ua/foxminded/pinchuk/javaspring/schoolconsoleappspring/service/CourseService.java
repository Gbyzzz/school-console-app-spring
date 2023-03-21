package ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.service;



import org.springframework.stereotype.Service;
import ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.bean.Course;
import ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.bean.Student;

import java.util.List;

@Service
public interface CourseService {
    List<Course> findAllCourses();

    void saveOrUpdate(Course course);

    void removeStudentFromCourse(Student student, Course course);

    Course findCourseById(int courseId) throws Exception;
}
