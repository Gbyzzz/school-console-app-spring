package ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.dao.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.IntegrationTestBase;
import ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.bean.Group;
import ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.repository.GroupRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class GroupDAOImplTest extends IntegrationTestBase {

    @Autowired
    private GroupRepository groupRepository;

    @Test
    void getAllGroups() {
        System.out.println(groupRepository.findAll());
        assertEquals(new ArrayList<Group>() {{
            add(new Group(1, "First"));
        }}, groupRepository.findAll());
    }

    @Test
    void getGroupById() {
        assertEquals(Optional.of(new Group(1, "First")),
                groupRepository.findById(1));
    }

    @Test
    void getGroupsByNumberOfStudents() {
        assertEquals(new ArrayList<Map<Object, Object>>() {{
            add(new HashMap<Object, Object> (){{
                put("0", new Group(1, "First"));
                put("1", 2);
            }});
        }}, groupRepository.findGroupsByStudentsIsGreaterThanAndStudentsIn(2));
    }
}