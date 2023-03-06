package ua.foxminded.pinchuk.javaspring.schoolconsoleappspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.controller.menu.Menu;
import ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.view.IOData;

@SpringBootApplication
public class SchoolConsoleAppSpringApplication {
    private static Menu menu;

    private static IOData ioData;

    public SchoolConsoleAppSpringApplication(Menu menu, IOData ioData) {

        this.menu = menu;
        this.ioData = ioData;
    }

    public static void main(String[] args) {
        try {
            SpringApplication.run(SchoolConsoleAppSpringApplication.class, args);
            menu.start();
        } catch (Exception e) {
            ioData.outputLine("Something went wrong: " + e);
        }
    }
}
