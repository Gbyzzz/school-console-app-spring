package ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.controller.command.impl;

import org.springframework.stereotype.Component;
import ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.controller.command.Command;
import ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.bean.Student;
import ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.service.GroupService;
import ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.service.StudentService;
import ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.view.IOData;

@Component
public class AddStudent implements Command {
    private IOData io;
    private GroupService groupService;
    private StudentService studentService;

    public AddStudent(IOData io, GroupService groupService, StudentService studentService) {
        this.io = io;
        this.groupService = groupService;
        this.studentService = studentService;
    }


    public void execute() {
        io.outputLine("Adding new student");
        io.outputLine("Please input student's first name:");
        String firstName = io.getString();
        io.outputLine("Please input student's last name:");
        String lastName = io.getString();
        io.outputLine("Groups:");
        io.outputList(groupService.findAllGroups());
        io.outputLine("Please input index of group from the list above:");


        studentService.addStudent(new Student(firstName, lastName, groupService.findGroupById(io.getInt())));
            io.outputLine("Successfully added");

    }
}
