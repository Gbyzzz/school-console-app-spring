package ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.bean;

import lombok.Data;

import java.util.Objects;

@Data
public class Group {
    private Integer groupId;
    private String groupName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return groupId == group.groupId && Objects.equals(groupName, group.groupName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupId, groupName);
    }

    @Override
    public String toString() {
        return groupId + ". " + groupName;
    }
}
