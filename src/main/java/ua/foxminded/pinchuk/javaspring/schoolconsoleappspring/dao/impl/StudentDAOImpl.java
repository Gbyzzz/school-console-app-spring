package ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.dao.impl;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.bean.Student;
import ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.dao.StudentDAO;
import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.dao.exception.DAOException;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {

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
