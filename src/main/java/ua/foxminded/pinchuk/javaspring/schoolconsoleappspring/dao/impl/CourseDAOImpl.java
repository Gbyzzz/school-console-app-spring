package ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.dao.impl;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.dao.CourseDAO;
import ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.bean.Course;

import java.util.List;

@Repository
public class CourseDAOImpl implements CourseDAO {

    private static final String SQL_GET_ALL_COURSES = "" +
            "SELECT * " +
            "FROM courses";
    private static final String SQL_GET_COURSE_BY_STUDENT = "" +
            "SELECT c.course_id, " +
            "       c.course_name, " +
            "       c.course_description " +
            "FROM courses_students cs " +
            "JOIN courses c ON cs.course_id=c.course_id " +
            "WHERE cs.student_id=?";
    private static final String SQL_ADD_STUDENT_TO_COURSE = "" +
            "INSERT INTO courses_students (student_id, course_id) " +
            "values (?, ?) " +
            "ON CONFLICT DO NOTHING";

    private static final String SQL_REMOVE_STUDENT_FROM_COURSE = "" +
            "DELETE FROM courses_students " +
            "WHERE student_id=? " +
            "AND course_id=?";
    private final JdbcTemplate jdbcTemplate;
    private final RowMapper<Course> courseRowMapper;

    public CourseDAOImpl(JdbcTemplate jdbcTemplate, RowMapper<Course> courseRowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.courseRowMapper = courseRowMapper;
    }


    @Override
    public List<Course> getAllCourses() {
        return jdbcTemplate.query(SQL_GET_ALL_COURSES, courseRowMapper);
    }

    @Override
    public List<Course> getCoursesByStudentId(int studentId) {
        return jdbcTemplate.query(SQL_GET_COURSE_BY_STUDENT, courseRowMapper, studentId);
    }

    @Override
    public void addStudentToCourse(int studentId, int courseId) {
        jdbcTemplate.update(SQL_ADD_STUDENT_TO_COURSE, studentId, courseId);
    }
    @Override
    public void removeStudentFromCourse(int studentId, int courseId) {
    jdbcTemplate.update(SQL_REMOVE_STUDENT_FROM_COURSE, studentId, courseId);
    }

}
