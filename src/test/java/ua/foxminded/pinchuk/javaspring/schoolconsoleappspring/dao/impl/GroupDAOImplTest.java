package ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.dao.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.IntegrationTestBase;
import ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.bean.Group;
import ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.dao.GroupDAO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class GroupDAOImplTest extends IntegrationTestBase {

    @Autowired
    private GroupDAO groupDAO;

    @Test
    void getAllGroups() {
        System.out.println(groupDAO.getAllGroups());
        assertEquals(new ArrayList<Group>() {{
            add(new Group(1, "First"));
        }}, groupDAO.getAllGroups());
    }

    @Test
    void getGroupById() {
        assertEquals(Optional.of(new Group(1, "First")), groupDAO.getGroupById(1));
    }

    @Test
    void getGroupsByNumberOfStudents() {
        assertEquals(new HashMap<Group, Integer>() {{
            put(new Group(1, "First"), 2);
        }}, groupDAO.getGroupsByNumberOfStudents(2));
    }
}