package ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.dao.CourseDAO;
import ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.bean.Course;

import java.util.List;

@Repository
public class CourseDAOImpl implements CourseDAO {
    @PersistenceContext
    private EntityManager entityManager;

    private static final String GET_ALL_COURSES = "" +
            "SELECT c " +
            "FROM Course c";
//    private static final String SQL_GET_COURSE_BY_STUDENT = "" +
//            "SELECT c.course_id, " +
//            "       c.course_name, " +
//            "       c.course_description " +
//            "FROM courses_students cs " +
//            "JOIN courses c ON cs.course_id=c.course_id " +
//            "WHERE cs.student_id=:id";
//    private static final String SQL_ADD_STUDENT_TO_COURSE = "" +
//            "INSERT INTO courses_students (student_id, course_id) " +
//            "values (:student_id, :course_id) " +
//            "ON CONFLICT DO NOTHING";
//
//    private static final String SQL_REMOVE_STUDENT_FROM_COURSE = "" +
//            "DELETE FROM courses_students " +
//            "WHERE student_id=:student_id " +
//            "AND course_id=:course_id";

    @Override
    public List<Course> getAllCourses() {
        return entityManager.createQuery(GET_ALL_COURSES, Course.class).getResultList();
    }

    @Override
    @Transactional
    public void saveOrUpdate(Course course) {
        entityManager.merge(course);
    }

    @Override
    public Course getCourseById(int courseId) {
        return entityManager.find(Course.class,courseId);
    }

//    @Override
//    public List<Course> getCoursesByStudentId(int studentId) {
//        return (List<Course>) entityManager.createQuery(SQL_GET_COURSE_BY_STUDENT).setParameter("id", studentId).getResultList();
//    }
//
//    @Override
//    public void addStudentToCourse(int studentId, int courseId) {
//        entityManager.createQuery(SQL_ADD_STUDENT_TO_COURSE).setParameter("studentId", studentId)
//                .setParameter("courseId", courseId).executeUpdate();
//    }
//    @Override
//    public void removeStudentFromCourse(int studentId, int courseId) {
//        entityManager.createQuery(SQL_REMOVE_STUDENT_FROM_COURSE).setParameter("studentId", studentId)
//                        .setParameter("courseId", courseId).executeUpdate();
//    }

}
