package ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.controller.menu;

import org.springframework.stereotype.Component;
import ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.controller.command.CommandProvider;
import ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.controller.command.Command;
import ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.view.IOData;

@Component
public class Menu {

    private IOData io;
    private CommandProvider commandProvider;

    public Menu(IOData io, CommandProvider commandProvider) {
        this.io = io;
        this.commandProvider = commandProvider;
    }

    public void start() {
        int select;
        Command command;
        io.outputLine("Hello! You've just started my program, please select the task which you want to launch:");
        while (true) {
            io.outputLine("1. Find all groups with less or equal students’ number");
            io.outputLine("2. Find all students related to the course with the given name");
            io.outputLine("3. Add a new student");
            io.outputLine("4. Delete a student by the STUDENT_ID");
            io.outputLine("5. Add a student to the course (from a list)");
            io.outputLine("6. Remove the student from one of their courses.");
            io.outputLine("Please input number of task from 1 to 6, or input 7 to exit the application");

            select = io.getIntFromRange(1, 7);
            if (select == 7) {
                break;
            }
            command = commandProvider.getCommand(select);
            command.execute();
        }
        close();
    }

    void close() {
        io.close();
        System.exit(0);
    }
}
