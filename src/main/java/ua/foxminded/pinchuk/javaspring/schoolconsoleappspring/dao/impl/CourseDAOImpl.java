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
}
