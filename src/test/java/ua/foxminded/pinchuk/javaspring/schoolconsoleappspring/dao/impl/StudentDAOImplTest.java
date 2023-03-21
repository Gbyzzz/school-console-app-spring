package ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.dao.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.IntegrationTestBase;
import ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.Source;
import ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.bean.Student;
import ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.repository.StudentRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class StudentDAOImplTest extends IntegrationTestBase {
    @Autowired
    private StudentRepository studentRepository;

    @ParameterizedTest
    @Order(3)
    @MethodSource("ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.Source#provideStudents")
    void saveOrUpdate(List<Student> expected) {
        Student student = new Student(3, "Sam", "Green", Source.group);
        student.setStudentId(studentRepository.save(student).getStudentId());
        expected.add(student);
        assertEquals(expected, studentRepository.findAll());
    }

    @ParameterizedTest
    @Order(2)
    @MethodSource("ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.Source#provideStudents")
    void getAllStudents(List<Student> expected) {
        assertEquals(expected, studentRepository.findAll());
    }

    @ParameterizedTest
    @Order(4)
    @MethodSource("ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.Source#provideStudents")
    void deleteStudentById(List<Student> expected) {
        studentRepository.delete(expected.get(2));
        expected.remove(2);
        assertEquals(expected, studentRepository.findAll());
    }

    @ParameterizedTest
    @Order(1)
    @MethodSource("ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.Source#provideGetStudentById")
    void getStudentById(Student student, int studentId) {
        assertEquals(Optional.of(student), studentRepository.findById(studentId));
    }
}