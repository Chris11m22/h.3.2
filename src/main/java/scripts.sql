select * from student where age > 10 and age < 20;
select * from student where name like '%о%';
select * from student where name is not null;
select * from student where age < student.id;
select * from student order by age;
SELECT COUNT(*) FROM student;
SELECT AVG(amount) from student by age;
SELECT * FROM student  OFFSET 4;