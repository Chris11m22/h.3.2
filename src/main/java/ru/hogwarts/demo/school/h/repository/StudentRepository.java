package ru.hogwarts.demo.school.h.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.hogwarts.demo.school.h.model.Student;
import ru.hogwarts.demo.school.h.model.StudentsByCategory;

import java.util.Collection;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

   Collection<Student> findByAgeBetween(int minAge, int maxAge);
@Query (value = "SELECT category, SUM(amount) as amount FROM student GROUP BY category" , nativeQuery = true)
    List<StudentsByCategory> getStudentsByCategory();

}
