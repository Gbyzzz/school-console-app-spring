package ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.service.impl;

import org.springframework.stereotype.Service;
import ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.bean.Course;
import ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.bean.Group;
import ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.bean.Student;
import ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.dao.CourseDAO;
import ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.dao.GroupDAO;
import ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.dao.StudentDAO;
import ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.service.InitDBService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Service
public class InitDBServiceImpl implements InitDBService {
    private CourseDAO courseDAO;
    private GroupDAO groupDAO;
    private StudentDAO studentDAO;
    private Random rand = new Random();
    private List<Student> students = new ArrayList<>();

    private String alphabet = "ABCDEFGHIJKLOMPQRSTUVWXVZ";
    private List<String> firstNames = Arrays.asList(("Adam, Sam, Dan, Johnny, Tom, Andy, William, Lenny, Kenny, Charles," +
            " Randy, Billy, Mike, Kelly, Sally, Vivian, Theresa, Natalie, Greg, Kim").split(", "));

    private List<String> lastNames = Arrays.asList(("Johnson, Green, West, Marley, Pierce, Smith, Williams, Brown, " +
            "Anderson, Jackson, White, Young, King, Scott, Hill, Mitchel, Carter, Parker, Morris, Murphy").split(", "));
    private List<Group> groups = new ArrayList<>();

    private List<Course> courses = new ArrayList<>(){{
        add(new Course(1, "Math", "Math lessons"));
        add(new Course(2, "Biology", "Biology lessons"));
        add(new Course(3, "Physics", "Physics lessons"));
        add(new Course(4, "IT", "IT lessons"));
        add(new Course(5, "English", "English lessons"));
        add(new Course(6, "Literature", "Literature lessons"));
        add(new Course(7, "Foreign language", "Foreign language lessons"));
        add(new Course(8, "Sport", "Sport activity"));
        add(new Course(9, "Astronomy", "Astronomy lessons"));
        add(new Course(10, "History", "History lessons"));
    }};

    public InitDBServiceImpl(CourseDAO courseDAO, GroupDAO groupDAO, StudentDAO studentDAO) {
        this.courseDAO = courseDAO;
        this.groupDAO = groupDAO;
        this.studentDAO = studentDAO;
    }


    @Override
    public void initDB() {
        if(!groupDAO.checkIfTableExists()) {
            generateGroupsTableWithContent();
        }
        if(!studentDAO.checkIfTableExists()) {
            generateStudentsTableWithContent();
        }
        if(!courseDAO.checkIfTableExists()) {
            generateCoursesTableWithContent();
        }

    }

    private void generateGroupsTableWithContent() {
        groupDAO.createTable();
        for (int i = 1; i <= 10; i++) {
            groups.add(new Group(i, new StringBuilder(alphabet.charAt(rand.nextInt(25)) +
                    alphabet.charAt(rand.nextInt(25)) + "-" + rand.nextInt(90)+10).toString()));
        }
        groupDAO.saveAll(groups);
    }


    private void generateStudentsTableWithContent() {
        studentDAO.createTable();
        for (int i = 1; i <= 200; i++) {
            students.add(new Student(i, firstNames.get(rand.nextInt(21)), lastNames.get(rand.nextInt(21)), groups.get(rand.nextInt(10)+1)));
        }
        studentDAO.saveAll(students);
    }

    private void generateCoursesTableWithContent() {
        courseDAO.createTable();
        courseDAO.saveAll(courses);

        for(Student student : students) {
            for (int i = 0; i <= rand.nextInt(2) + 1; i++) {
                courses.get(rand.nextInt(9)+1).getStudents().add(student);
            }
        }
        courseDAO.saveAllStudentsToCourses(courses);
    }
}