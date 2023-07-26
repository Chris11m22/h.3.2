package ru.hogwarts.demo.school.h.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hogwarts.demo.school.h.model.Faculty;
import ru.hogwarts.demo.school.h.model.Student;

import java.util.Collection;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {

    Collection<Faculty> findByColorIgnoreCase(String color);

    Collection<Faculty> findByNameIgnoreCase(String name);

    Collection<Faculty> findFacultiesByNameOrColor(String name, String color);

    Collection<Student> findAllStudentsByFaculty_Id(Long id);
}
