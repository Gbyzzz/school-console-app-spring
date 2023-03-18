package ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.service.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.Source;
import ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.service.GroupService;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = {GroupServiceImpl.class})
class GroupServiceImplTest {
    @MockBean
    GroupDAO groupDAO;

    @Autowired
    GroupService groupService;

    @Test
    void findAllGroups() {
        when(groupDAO.getAllGroups()).thenReturn(Arrays.asList(Source.group));
        assertEquals(Arrays.asList(Source.group), groupService.findAllGroups());
    }

    @Test
    void findGroupById() {
        when(groupDAO.getGroupById(0)).thenReturn(Optional.of(Source.group));
        assertEquals(Source.group, groupService.findGroupById(0));
    }

    @Test
    void findGroupsByNumberOfStudents() {
        when(groupDAO.getGroupsByNumberOfStudents(2)).thenReturn(Map.of(Source.group, 2));
        assertEquals(Map.of(Source.group, 2), groupService.findGroupsByNumberOfStudents(2));
    }
}