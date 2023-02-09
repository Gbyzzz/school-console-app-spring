package ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    private Integer courseId;
    private String courseName;
    private String courseDescription;

    private List<Student> students;

    public Course(Integer courseId, String courseName, String courseDescription) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseDescription = courseDescription;
    }

//    @Override
//    public String toString() {
//        return courseId + " . " + courseName + ": " + courseDescription;
//    }

}
