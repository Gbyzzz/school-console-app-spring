package ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.bean;

import lombok.Data;

import java.util.List;
import java.util.Objects;

@Data
public class Course {
    private Integer courseId;
    private String courseName;
    private String courseDescription;

    private List<Student> students;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return courseId == course.courseId && Objects.equals(courseName, course.courseName)
                && Objects.equals(courseDescription, course.courseDescription) && Objects.equals(students, course.students);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseId, courseName, courseDescription, students);
    }

    @Override
    public String toString() {
        return courseId + ". " + courseName + ": " + courseDescription;
    }

}
