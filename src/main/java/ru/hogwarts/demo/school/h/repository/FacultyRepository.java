package ru.hogwarts.demo.school.h.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hogwarts.demo.school.h.model.Faculty;

import java.util.Collection;

public interface FacultyRepository extends JpaRepository <Faculty, Long>{

    Collection<Faculty> findByColor(String color);


}
