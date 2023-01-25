package ua.foxminded.pinchuk.javaspring.schoolconsoleappspring;

import org.junit.jupiter.api.BeforeAll;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;
import ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.initializer.Postgres;

@SpringBootTest
@Transactional
@ActiveProfiles("test")
@ContextConfiguration(initializers = {
        Postgres.Initializer.class
})
public abstract class IntegrationTestBase {
    @BeforeAll
    static void init(){
        Postgres.container.start();
    }
}
