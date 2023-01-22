package ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.dao.utils;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.bean.Student;
import ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.dao.GroupDAO;

import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class StudentRowMapper implements RowMapper<Student> {
    private GroupDAO groupDAO;

    public StudentRowMapper(GroupDAO groupDAO) {
        this.groupDAO = groupDAO;
    }

    @Override
    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
        Student student = new Student();
        student.setStudentId(rs.getInt("student_id"));
        student.setFirstName(rs.getString("first_name"));
        student.setLastName(rs.getString("last_name"));
        student.setGroup(groupDAO.getGroupById(rs.getInt("group_id")).get());
        return student;
    }
}
