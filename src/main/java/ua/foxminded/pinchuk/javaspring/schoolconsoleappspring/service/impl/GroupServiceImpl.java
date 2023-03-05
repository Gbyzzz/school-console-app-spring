package ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.bean.Group;
import ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.service.GroupService;
import ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.dao.GroupDAO;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class GroupServiceImpl implements GroupService {

    private GroupDAO groupDAO;

    public GroupServiceImpl(GroupDAO groupDAO) {
        this.groupDAO = groupDAO;
    }

    @Override
    public List<Group> findAllGroups() {
        return groupDAO.getAllGroups();
    }

    @Override
    public Group findGroupById(int id){
        Optional<Group> optionalGroup = groupDAO.getGroupById(id);
        Group group = null;
        if (optionalGroup.isPresent()) {
            group = optionalGroup.get();
        }
        return group;
    }

    @Override
    @Transactional
    public Map<Group, Integer> findGroupsByNumberOfStudents(int students) {
        return groupDAO.getGroupsByNumberOfStudents(students);
    }


}
