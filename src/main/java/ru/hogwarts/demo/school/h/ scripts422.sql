CREATE TABLE table_name(
column1 datatype,
column2 datatype,
);
ALTER TABLE table_name ADD column_name datatype;
ALTER TABLE table_name DROP COLUMN column_name;
ALTER TABLE table_name RENAME COLUMN column_name TO new_column_name;
ALTER TABLE table_name ALTER COLUMN column_name TYPE new_datatype;
SELECT student.name, student.age, faculty.faculty
FROM student
INNER JOIN faculty ON student.faculty_id = faculty.id
SELECT student.name
FROM student
INNER JOIN avatar ON student.avatar_id = avatar.id