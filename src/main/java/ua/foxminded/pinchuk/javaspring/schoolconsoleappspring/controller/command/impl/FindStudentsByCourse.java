package ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.controller.command.impl;

import org.springframework.stereotype.Component;
import ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.bean.Course;
import ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.controller.command.Command;
import ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.service.CourseService;
import ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.service.StudentService;
import ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.view.IOData;

import java.util.List;

@Component
public class FindStudentsByCourse implements Command {
    private IOData io;
    private StudentService studentService;
    private CourseService courseService;

    public FindStudentsByCourse(IOData io, StudentService studentService, CourseService courseService) {
        this.io = io;
        this.studentService = studentService;
        this.courseService = courseService;
    }

    public void execute() {
        List<Course> courses = courseService.findAllCourses();
        if (!courses.isEmpty()) {
            io.outputLine("Please select course from the list below:");
            io.outputList(courses);
            io.outputLine("Input the index of the course");
            int courseId = io.getInt();
            io.outputList(studentService.findStudentsByCourse(courseId));
            io.outputLine("");
        } else {
            io.outputLine("No courses were found");
        }

    }
}