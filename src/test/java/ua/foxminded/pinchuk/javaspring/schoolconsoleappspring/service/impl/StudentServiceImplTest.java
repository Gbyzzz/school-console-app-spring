package ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.service.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.Source;
import ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.dao.StudentRepository;
import ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.service.StudentService;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = {StudentServiceImpl.class})
class StudentServiceImplTest {

    @MockBean
    StudentRepository studentRepository;

    @Autowired
    StudentService studentService;

    @Test
    void findAllStudents() {
        when(studentRepository.findAll()).thenReturn(Source.students);
        assertEquals(Source.students, studentService.findAllStudents());
    }
}