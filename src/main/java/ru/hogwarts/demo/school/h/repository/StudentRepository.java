package ru.hogwarts.demo.school.h.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hogwarts.demo.school.h.model.Faculty;
import ru.hogwarts.demo.school.h.model.Student;

import java.util.Collection;

public interface StudentRepository extends JpaRepository<Student,Long> {

    Collection<Student> findBy();
}
