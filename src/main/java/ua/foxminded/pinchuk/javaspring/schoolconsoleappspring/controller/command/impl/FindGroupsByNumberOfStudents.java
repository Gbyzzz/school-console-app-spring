package ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.controller.command.impl;

import org.springframework.stereotype.Component;
import ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.bean.Group;
import ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.controller.command.Command;
import ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.service.GroupService;
import ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.view.IOData;

import java.util.Map;

@Component
public class FindGroupsByNumberOfStudents implements Command {
    private IOData io;
    private GroupService groupService;

    public FindGroupsByNumberOfStudents(IOData io, GroupService groupService) {
        this.io = io;
        this.groupService = groupService;
    }

    public void execute() {
        io.outputLine("Find all groups with less or equal students’ number");
        io.outputLine("Please input a number of students in group:");
        int students = io.getInt();
        Map<Group, Integer> map = groupService.findGroupsByNumberOfStudents(students);
        if (!map.isEmpty()) {
            io.outputMap(map);
        } else {
            io.outputLine("No group with such number of students were found");
        }
        io.outputLine("");
        System.out.println(10/0);
    }
}