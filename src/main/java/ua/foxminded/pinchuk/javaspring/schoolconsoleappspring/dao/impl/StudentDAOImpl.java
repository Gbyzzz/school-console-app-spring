package ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.dao.impl;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.bean.Group;
import ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.bean.Student;
import ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.dao.StudentDAO;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.dao.exception.DAOException;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {

    private static final String SQL_CHECK_IF_TABLE_EXISTS = "" +
            "SELECT EXISTS (" +
            "   SELECT FROM information_schema.tables " +
            "   WHERE  table_schema = 'public'" +
            "   AND    table_name   = 'students'" +
            "   );";

    private static final String SQL_CREATE_TABLE = "" +
            "CREATE TABLE students (" +
            "    student_id bigint GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY," +
            "    group_id   bigint REFERENCES groups (group_id)," +
            "    first_name varchar(20) NOT NULL," +
            "    last_name  varchar(20) NOT NULL" +
            ");";

    private static final String SQL_SAVE_ALL = "" +
            "INSERT INTO students " +
            "VALUES (?, ?, ?, ?);";

    private static final String SQL_GET_ALL_STUDENTS = "" +
            "SELECT s.student_id, " +
            "       s.first_name, " +
            "       s.last_name, " +
            "       g.group_id, " +
            "       g.group_name " +
            "FROM students s " +
            "JOIN groups g ON s.group_id=g.group_id";
    private static final String SQL_REMOVE_STUDENT_BY_ID = "" +
            "DELETE FROM students " +
            "WHERE student_id=?";
    private static final String SQL_ADD_STUDENT = "" +
            "INSERT INTO students (first_name, last_name, group_id) " +
            "values (?, ?, ?)";

    private static final String SQL_GET_STUDENTS_BY_COURSE_ID = "" +
            "SELECT s.student_id, " +
            "       s.first_name, " +
            "       s.last_name, " +
            "       g.group_id," +
            "       g.group_name " +
            "FROM courses_students " +
            "JOIN students s ON courses_students.student_id=s.student_id " +
            "JOIN groups g ON s.group_id=g.group_id " +
            "WHERE course_id=?";

    private final JdbcTemplate jdbcTemplate;
    private final RowMapper<Student> studentRowMapper;

    public StudentDAOImpl(JdbcTemplate jdbcTemplate, RowMapper<Student> studentRowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.studentRowMapper = studentRowMapper;
    }

    @Override
    public boolean checkIfTableExists() {
        return jdbcTemplate.queryForObject(SQL_CHECK_IF_TABLE_EXISTS, Boolean.class);
    }

    @Override
    public void createTable() {
        jdbcTemplate.update(SQL_CREATE_TABLE);
    }

    @Override
    public void saveAll(List<Student> students) {
        jdbcTemplate.batchUpdate(SQL_SAVE_ALL, new BatchPreparedStatementSetter() {

            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                Student student = students.get(i);
                ps.setInt(1, student.getStudentId());
                ps.setInt(2, student.getGroup().getGroupId());
                ps.setString(3, student.getFirstName());
                ps.setString(4, student.getLastName());
            }
            @Override
            public int getBatchSize() {
                return students.size();
            }
        });
    }

    @Override
    public void addStudent(Student student) {
        jdbcTemplate.update(SQL_ADD_STUDENT, student.getFirstName(),
                student.getLastName(), student.getGroup().getGroupId());
    }

    @Override
    public List<Student> getAllStudents() throws DAOException {
        return jdbcTemplate.query(SQL_GET_ALL_STUDENTS, studentRowMapper);
    }

    @Override
    public void deleteStudentById(int studentId) {
        jdbcTemplate.update(SQL_REMOVE_STUDENT_BY_ID, studentId);
    }

    @Override
    public List<Student> getStudentsByCourseId(int courseId) {
        return jdbcTemplate.query(SQL_GET_STUDENTS_BY_COURSE_ID, studentRowMapper, courseId);
    }
}
