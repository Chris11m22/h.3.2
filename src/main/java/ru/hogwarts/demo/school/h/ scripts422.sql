create table person (
    id serial primary key ,
    nickName char(100) not null ,
    age integer not null check ( age>20 ),
    driver_license boolean,
    car_id integer references car(id)
);
create table car (
    id serial primary key ,
    brand char(100) not null ,
    model char(100) not null,
    price numeric not null
);

select student.name, student.age, faculty.name
from student
inner join faculty on student.faculty_id = faculty.id
select student.name, student.age
from student
left join avatar on student.avatar_id = avatar.id where a.data notnull ;