package ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.bean.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
}
