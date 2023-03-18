package ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.service.impl;

import org.springframework.stereotype.Service;
import ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.bean.Student;
import ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.dao.CourseRepository;
import ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.bean.Course;
import ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.service.CourseService;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Course> findAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public void saveOrUpdate(Course course) {
        courseRepository.save(course);
    }

    @Override
    public void removeStudentFromCourse(Student student, Course course) {
        course.getStudents().remove(student);
        courseRepository.save(course);
    }

    @Override
    public Course findCourseById(int courseId) {
        Optional<Course> course = courseRepository.findById(courseId);
        if(course.isPresent()){
            return course.get();
        }
        return null;
    }
}
