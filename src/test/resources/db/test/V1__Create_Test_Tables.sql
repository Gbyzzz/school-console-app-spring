DROP TABLE IF EXISTS courses_students;
DROP TABLE IF EXISTS students;
DROP TABLE IF EXISTS courses;
DROP TABLE IF EXISTS groups;

CREATE TABLE groups
(
    group_id   bigint GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    group_name varchar(20) NOT NULL
);

INSERT INTO groups
VALUES (1, 'First');

SELECT setval('groups_group_id_seq', (SELECT MAX(group_id) from "groups"));


CREATE TABLE students
(
    student_id bigint GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    group_id   bigint REFERENCES groups (group_id),
    first_name varchar(20) NOT NULL,
    last_name  varchar(20) NOT NULL
);

INSERT INTO students (group_id, first_name, last_name)
VALUES (1, 'John', 'Smith'),
       (1, 'Jeremy', 'Brown');

SELECT setval('students_student_id_seq', (SELECT MAX(student_id) from "students"));


CREATE TABLE courses
(
    course_id          bigint GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    course_name        varchar(20)  NOT NULL,
    course_description varchar(100) NOT NULL
);

INSERT INTO courses
VALUES (1, 'Math', 'Math lessons'),
       (2, 'Physics', 'Physics lessons');

SELECT setval('courses_course_id_seq', (SELECT MAX(course_id) from "courses"));


CREATE TABLE courses_students
(
    course_id  bigint NOT NULL REFERENCES courses (course_id),
    student_id bigint NOT NULL REFERENCES students (student_id) ON DELETE CASCADE,
    UNIQUE (course_id, student_id)
);

INSERT INTO courses_students
VALUES (1, 1),
       (2, 1),
       (2, 2);