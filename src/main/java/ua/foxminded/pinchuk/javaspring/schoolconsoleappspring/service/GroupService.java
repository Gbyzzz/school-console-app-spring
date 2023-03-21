package ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.service;

import ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.bean.Group;

import java.util.List;
import java.util.Map;

public interface GroupService {
    List<Group> findAllGroups();

    Group findGroupById(int id) throws Exception;

    Map<Group, Integer> findGroupsByNumberOfStudents(int students);
}
