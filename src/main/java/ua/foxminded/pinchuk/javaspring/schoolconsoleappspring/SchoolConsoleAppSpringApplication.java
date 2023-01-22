package ua.foxminded.pinchuk.javaspring.schoolconsoleappspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.controller.menu.Menu;

@SpringBootApplication
public class SchoolConsoleAppSpringApplication {

    private static Menu menu;

    public SchoolConsoleAppSpringApplication(Menu menu) {
        this.menu = menu;
    }

    public static void main(String[] args) {
        SpringApplication.run(SchoolConsoleAppSpringApplication.class, args);
        menu.start();
    }
}
