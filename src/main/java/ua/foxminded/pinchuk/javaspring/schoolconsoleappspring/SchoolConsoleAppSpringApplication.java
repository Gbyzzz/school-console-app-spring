package ua.foxminded.pinchuk.javaspring.schoolconsoleappspring;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.controller.menu.Menu;
import ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.service.InitDBService;

@SpringBootApplication
public class SchoolConsoleAppSpringApplication implements ApplicationRunner {

    private static Menu menu;
    private static InitDBService initDBService;

    public SchoolConsoleAppSpringApplication(Menu menu, InitDBService initDBService) {
        this.menu = menu;
        this.initDBService = initDBService;
    }

    public static void main(String[] args) {
        SpringApplication.run(SchoolConsoleAppSpringApplication.class, args);
        menu.start();
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        initDBService.initDB();
    }
}
