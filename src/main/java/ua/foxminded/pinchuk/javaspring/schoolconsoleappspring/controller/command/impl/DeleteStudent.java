package ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.controller.command.impl;

import org.springframework.stereotype.Component;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.dao.exception.DAOException;
import ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.bean.Student;
import ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.controller.command.Command;
import ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.service.StudentService;
import ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.view.IOData;

import java.util.List;


@Component
public class DeleteStudent implements Command {
    private IOData io;
    private StudentService studentService;

    public DeleteStudent(IOData io, StudentService studentService) {
        this.io = io;
        this.studentService = studentService;
    }

    public void execute() throws DAOException {
        List<Student> students = studentService.findAllStudents();
        if (!students.isEmpty()) {
            io.outputLine("Please select student from the list below:");
            io.outputList(students);
            io.outputLine("Input the index of the student");
            int studentId = io.getInt();
            studentService.deleteStudentById(studentId);
        } else {
            io.outputLine("No students were found");
        }

    }
}
