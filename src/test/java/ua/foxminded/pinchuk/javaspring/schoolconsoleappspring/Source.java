package ua.foxminded.pinchuk.javaspring.schoolconsoleappspring;

import org.junit.jupiter.params.provider.Arguments;
import ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.bean.Course;
import ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.bean.Group;
import ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.bean.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Source {
    public static Group group = new Group(1, "First");
    public static List<Student> students = new ArrayList<>() {{
        add(new Student(1, "John", "Smith", group));
        add(new Student(2, "Jeremy", "Brown", group));
    }};

    public static List<Course> courses = new ArrayList<>() {{
        add(new Course(1, "Math",
                "Math lessons"));
        add(new Course(2, "Physics",
                "Physics lessons"));
    }};
    public static List<Course> coursesWithStudents = new ArrayList<>() {{
        add(new Course(1, "Math",
                "Math lessons", new ArrayList<>(){{add(students.get(0));}}));
        add(new Course(2, "Physics",
                "Physics lessons", students));
    }};

    public static Stream<Arguments> provideCoursesByStudent() {
        return Stream.of(
                Arguments.of(new ArrayList<Course>() {{
                                 add(new Course(1, "Math",
                                         "Math lessons"));
                                 add(new Course(2, "Physics",
                                         "Physics lessons"));
                             }}
                        , 1),
                Arguments.of(new ArrayList<Course>() {{
                                 add(new Course(2, "Physics",
                                         "Physics lessons"));
                             }}
                        , 2)
        );
    }
    public static Stream<Arguments> provideStudents() {

        return Stream.of(
                Arguments.of(students));
    }

    public static Stream<Arguments> provideGetStudentById() {

        return Stream.of(
                Arguments.of(students.get(0), 1),
                Arguments.of(students.get(1), 2));
    }

    public static Stream<Arguments> provideCourses() {

        return Stream.of(
                Arguments.of(students, 0),
                Arguments.of(null, 1));
    }

}
