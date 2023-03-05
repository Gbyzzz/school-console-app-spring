package ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.bean.Student;
import ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.dao.StudentDAO;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {
    @PersistenceContext
    private EntityManager entityManager;


    private static final String GET_ALL_STUDENTS = "" +
            "SELECT s " +
            "FROM Student s";

//    private static final String SQL_ADD_STUDENT = "" +
//            "INSERT INTO students (first_name, last_name, group_id) " +
//            "values (?, ?, ?)";
//
//    private static final String SQL_GET_STUDENTS_BY_COURSE_ID = "" +
//            "SELECT s.student_id, " +
//            "       s.first_name, " +
//            "       s.last_name, " +
//            "       g.group_id," +
//            "       g.group_name " +
//            "FROM courses_students " +
//            "JOIN students s ON courses_students.student_id=s.student_id " +
//            "JOIN groups g ON s.group_id=g.group_id " +
//            "WHERE course_id=?";

//    private final JdbcTemplate jdbcTemplate;
//    private final RowMapper<Student> studentRowMapper;

//    public StudentDAOImpl(JdbcTemplate jdbcTemplate, RowMapper<Student> studentRowMapper) {
//        this.jdbcTemplate = jdbcTemplate;
//        this.studentRowMapper = studentRowMapper;
//    }

    @Override
    public void saveOrUpdate(Student student) {
        entityManager.merge(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return entityManager.createQuery(GET_ALL_STUDENTS, Student.class).getResultList();
    }

    @Override
    public void deleteStudentById(Student student) {
        entityManager.remove(entityManager.contains(student) ? student : entityManager.merge(student));
    }

    @Override
    public Student getStudentById(int studentId) {
        return entityManager.find(Student.class, studentId);
    }
}
