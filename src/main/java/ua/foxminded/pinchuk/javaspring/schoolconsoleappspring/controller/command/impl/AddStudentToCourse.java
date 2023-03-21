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
public class AddStudentToCourse implements Command {
    private IOData io;
    private StudentService studentService;
    private CourseService courseService;

    public AddStudentToCourse(IOData io, StudentService studentService, CourseService courseService) {
        this.io = io;
        this.studentService = studentService;
        this.courseService = courseService;
    }

    public void execute() {
        List<Course> courses = courseService.findAllCourses();
        List<Student> students = studentService.findAllStudents();
        if (!courses.isEmpty() && !students.isEmpty()) {
            io.outputLine("Adding student to new course:");
            io.outputLine("Please select student from the list below:");
            io.outputList(students);
            io.outputLine("Input the index of the student");
            int studentId = io.getInt();
            Student student = null;
            try {
                student = studentService.findStudentById(studentId);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            io.outputLine("This student already visiting next courses:");
            io.outputList(student.getCourses());
            io.outputLine("List of available courses:");
            io.outputList(courses);
            io.outputLine("");
            io.outputLine("Input the index of the course");
            int courseId = io.getInt();
            Course course = null;
            try {
                course = courseService.findCourseById(courseId);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            course.getStudents().add(student);
            courseService.saveOrUpdate(course);
        } else {
            io.outputLine("No students or courses were found");
        }

    }
}
