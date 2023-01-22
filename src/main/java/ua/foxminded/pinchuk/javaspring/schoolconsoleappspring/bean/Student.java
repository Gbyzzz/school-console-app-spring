package ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@NoArgsConstructor
public class Student {
    private Integer studentId;
    private String firstName;
    private String lastName;
    private Group group;

    public Student(String firstName, String lastName, Group group) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.group = group;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return studentId == student.studentId && Objects.equals(group, student.group) &&
                Objects.equals(firstName, student.firstName) && Objects.equals(lastName, student.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, group, firstName, lastName);
    }

    @Override
    public String toString() {
        return studentId + ". " + firstName + " " + lastName + ", group: " + group.getGroupName()
                + "(#" + group.getGroupId() + ")";
    }
}
