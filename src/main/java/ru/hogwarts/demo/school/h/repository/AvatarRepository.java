package ru.hogwarts.demo.school.h.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hogwarts.demo.school.h.model.Avatar;

import java.util.Optional;

public interface AvatarRepository extends JpaRepository<Avatar, Long> {


    Optional<Avatar> findByStudentId(Long studentId);
}
