package ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.dao.GroupDAO;
import ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.bean.Group;


import java.util.*;
import java.util.stream.Collectors;

@Repository
public class GroupDAOImpl implements GroupDAO {

    @PersistenceContext
    private EntityManager entityManager;

    private static final String GET_ALL_GROUPS = "" +
            "select g " +
            "from Group g";
    private static final String GET_GROUP_BY_ID = "" +
            "select g from Group g where groupId = :id";

    private static final String SQL_GET_GROUPS_BY_NUMBER_OF_STUDENTS = "" +
            "select g from Group g where size(g.students) < :num";

    @Override
    public List<Group> getAllGroups() {
        return entityManager.createQuery(GET_ALL_GROUPS, Group.class).getResultList();
    }

    @Override
    public Optional<Group> getGroupById(int id) {
        Group group = entityManager.createQuery(GET_GROUP_BY_ID, Group.class)
                .setParameter("id", id)
                .getSingleResult();
        return Optional.ofNullable(group);
    }

    @Override
    public Map<Group, Integer> getGroupsByNumberOfStudents(int students) {
        return entityManager.createQuery(SQL_GET_GROUPS_BY_NUMBER_OF_STUDENTS, Group.class).setParameter("num", students)
                .getResultStream()
                .collect(
                        Collectors.toMap(
                        group->(group),
                        group->(group.getStudents().size())
                )
        );
    }
//        return jdbcTemplate.query(SQL_GET_GROUPS_BY_NUMBER_OF_STUDENTS,
//                preparedStatement -> preparedStatement.setInt(1, students),
//                rs -> {
//                    Map<Group, Integer> res = new HashMap<>();
//                    while (rs.next()) {
//                        res.put(groupRowMapper.mapRow(rs, 0), rs.getInt("total_students"));
//                    }
//                    return res;
//                });
//    }
}
