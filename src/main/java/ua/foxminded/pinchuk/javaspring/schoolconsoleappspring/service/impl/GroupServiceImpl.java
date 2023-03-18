package ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.bean.Group;
import ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.dao.GroupRepository;
import ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.service.GroupService;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class GroupServiceImpl implements GroupService {

    private GroupRepository groupRepository;

    public GroupServiceImpl(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @Override
    public List<Group> findAllGroups() {
        return groupRepository.findAll();
    }

    @Override
    public Group findGroupById(int id) {
        Optional<Group> group = groupRepository.findById(id);
        if (group.isPresent()) {
            return group.get();
        }
        return null;
    }

    @Override
    @Transactional
    public Map<Group, Integer> findGroupsByNumberOfStudents(int students) {
        return groupRepository.findGroupsByStudentsIsGreaterThanAndStudentsIn(students)
                .stream().collect(Collectors.toMap(
                el -> ((Group) el.get("0")),
                el -> ((Integer) el.get("1"))
        ));
    }
}





