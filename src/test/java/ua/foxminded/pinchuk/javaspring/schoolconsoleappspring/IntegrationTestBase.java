package ua.foxminded.pinchuk.javaspring.schoolconsoleappspring;

import org.junit.jupiter.api.BeforeAll;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.testcontainers.junit.jupiter.Testcontainers;
import ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.dao.CourseDAO;
import ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.initializer.Postgres;


@ActiveProfiles("test")
@Testcontainers
@ComponentScan(includeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,
        classes = {CourseDAO.class, StudentDAO.class, GroupDAO.class}))
@ContextConfiguration(initializers = {
        Postgres.Initializer.class
})
public abstract class  IntegrationTestBase {


    @BeforeAll
    static void init(){
        Postgres.container.start();
    }

}
