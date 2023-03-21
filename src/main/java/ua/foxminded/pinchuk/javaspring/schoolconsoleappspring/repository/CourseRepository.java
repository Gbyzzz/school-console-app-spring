package ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.bean.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
}
