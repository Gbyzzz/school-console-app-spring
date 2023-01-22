package ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.dao.impl;


import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.dao.GroupDAO;
import ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.bean.Group;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Repository
public class GroupDAOImpl implements GroupDAO {

    private static final String SQL_GET_ALL_GROUPS = "" +
            "SELECT * " +
            "FROM groups";
    private static final String SQL_GET_GROUP_BY_ID = "" +
            "SELECT group_id, " +
            "       group_name " +
            "FROM groups " +
            "WHERE group_id=?";
    private static final String SQL_GET_GROUPS_BY_NUMBER_OF_STUDENTS = "" +
            "SELECT g.group_id, " +
            "       g.group_name, " +
            "COUNT(s.group_id) AS total_students " +
            "FROM groups g " +
            "LEFT OUTER JOIN students s ON s.group_id=g.group_id " +
            "GROUP BY g.group_id " +
            "HAVING COUNT(s.group_id)<=? " +
            "ORDER BY total_students ASC";

    private final JdbcTemplate jdbcTemplate;
    private final RowMapper<Group> groupRowMapper;
    public GroupDAOImpl(JdbcTemplate jdbcTemplate, RowMapper<Group> groupRowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.groupRowMapper = groupRowMapper;

    }


    @Override
    public List<Group> getAllGroups() {
        return jdbcTemplate.query(SQL_GET_ALL_GROUPS, groupRowMapper);
    }

    @Override
    public Optional<Group> getGroupById(int id) {
        try {
            return Optional.of(jdbcTemplate
                    .queryForObject(SQL_GET_GROUP_BY_ID, groupRowMapper, id));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public Map<Group, Integer> getGroupsByNumberOfStudents(int students) {
       return jdbcTemplate.query(SQL_GET_GROUPS_BY_NUMBER_OF_STUDENTS,
               preparedStatement -> preparedStatement.setInt(1, students),
               (ResultSet rs, int rowNum) -> {
           Map<Group, Integer> res = new HashMap<>();
           while (rs.next()){
               res.put(groupRowMapper.mapRow(rs, rowNum), rs.getInt("total_students"));
           }
           return res;
       }).get(0);
    }


}
