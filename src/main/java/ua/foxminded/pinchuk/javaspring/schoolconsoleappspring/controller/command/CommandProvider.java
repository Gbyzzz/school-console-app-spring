package ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.controller.command;

import org.springframework.stereotype.Component;
import ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.controller.command.impl.*;

import java.util.HashMap;
import java.util.Map;

@Component
public class CommandProvider {
    private final Map<Integer, Command> repository = new HashMap<>();

    public CommandProvider(FindGroupsByNumberOfStudents findGroupsByNumberOfStudents,
                           FindStudentsByCourse findStudentsByCourse, AddStudent addStudent,
                           DeleteStudent deleteStudent, AddStudentToCourse addStudentToCourse,
                           RemoveStudentFromCourse removeStudentFromCourse) {
        repository.put(1, findGroupsByNumberOfStudents);
        repository.put(2, findStudentsByCourse);
        repository.put(3, addStudent);
        repository.put(4, deleteStudent);
        repository.put(5, addStudentToCourse);
        repository.put(6, removeStudentFromCourse);
    }

    public Command getCommand(int select) {
        return repository.get(select);
    }
}
