package ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.controller.command.impl;

import org.springframework.stereotype.Component;
import ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.bean.Course;
import ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.bean.Student;
import ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.controller.command.Command;
import ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.service.CourseService;
import ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.service.StudentService;
import ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.view.IOData;

import java.util.List;

@Component
public class RemoveStudentFromCourse implements Command {
    private IOData io;
    private StudentService studentService;
    private CourseService courseService;

    public RemoveStudentFromCourse(IOData io, StudentService studentService, CourseService courseService) {
        this.io = io;
        this.studentService = studentService;
        this.courseService = courseService;
    }

    public void execute() {
        List<Course> courses = courseService.findAllCourses();
        List<Student> students = studentService.findAllStudents();
        if (!courses.isEmpty() && !students.isEmpty()) {
            io.outputLine("Removing student from course:");
            io.outputLine("Please select student from the list below:");
            io.outputList(students);
            io.outputLine("Input the index of the student");
            Student student = studentService.findStudentById(io.getInt());
            io.outputLine("This student is visiting next courses:");
            io.outputList(student.getCourses());
            io.outputLine("Input the index of the course you want to delete");
            Course course = courseService.findCourseById(io.getInt());
            courseService.removeStudentFromCourse(student, course);

        } else {
            io.outputLine("No students or courses were found");
            io.outputLine("");
        }

    }
}
