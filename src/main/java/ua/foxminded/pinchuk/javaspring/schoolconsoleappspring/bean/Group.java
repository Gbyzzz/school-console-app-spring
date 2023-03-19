package ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.bean;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Objects;
@Entity
@Table(name = "groups")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "group_id")
    private Integer groupId;
    @Column(name = "group_name")
    private String groupName;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "students", joinColumns = { @JoinColumn(name = "group_id") },
            inverseJoinColumns = { @JoinColumn(name = "student_id") })
    private List<Student> students;

    public Group() {
    }

    public Group(Integer groupId, String groupName) {
        this.groupId = groupId;
        this.groupName = groupName;
    }

    public Group(Integer groupId, String groupName, List<Student> students) {
        this.groupId = groupId;
        this.groupName = groupName;
        this.students = students;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return Objects.equals(groupId, group.groupId) &&
                Objects.equals(groupName, group.groupName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupId, groupName);
    }

//    @Override
//    public String toString() {
//        return "Group{" +
//                "groupId=" + groupId +
//                ", groupName='" + groupName + '\'' +
//                ", students=" + students +
//                '}';
//    }

    @Override
    public String toString() {
        return groupId + ". " + groupName;
    }
}
