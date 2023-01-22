package ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.dao;

public enum ColumnName {
    STUDENT_ID("student_id"),
    FIRST_NAME("first_name"),
    LAST_NAME("last_name"),
    GROUP_ID("group_id"),
    GROUP_NAME("group_name"),
    COURSE_ID("course_id"),
    COURSE_NAME("course_name"),
    COURSE_DESCRIPTION("course_description"),
    TOTAL_STUDENTS("total_students");

    private final String value;

    ColumnName(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}

