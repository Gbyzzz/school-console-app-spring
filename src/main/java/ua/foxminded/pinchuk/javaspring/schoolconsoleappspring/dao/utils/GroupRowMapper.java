package ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.dao.utils;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.bean.Group;

import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class GroupRowMapper implements RowMapper<Group> {
    @Override
    public Group mapRow(ResultSet rs, int rowNum) throws SQLException {
        Group group = new Group();
        group.setGroupId(rs.getInt("group_id"));
        group.setGroupName(rs.getString("group_name"));
        return group;
    }
}
