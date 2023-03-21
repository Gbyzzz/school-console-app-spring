package ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.bean.Student;
import ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.repository.StudentRepository;
import ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.service.StudentService;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    @Transactional
    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public List<Student> findAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public void deleteStudent(Student student) {
        studentRepository.delete(student);
    }

    @Override
    public Student findStudentById(int studentId) throws Exception {
        Optional<Student> student = studentRepository.findById(studentId);
        if(student.isPresent()){
            return student.get();
        }
    throw new Exception();
    }


}
