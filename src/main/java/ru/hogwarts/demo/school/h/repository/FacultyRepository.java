package ru.hogwarts.demo.school.h.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hogwarts.demo.school.h.model.Student;

public interface FacultyRepository extends JpaRepository <Student, Long>{
}
