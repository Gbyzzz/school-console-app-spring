package ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
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
