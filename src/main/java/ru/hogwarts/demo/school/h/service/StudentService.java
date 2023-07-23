package ru.hogwarts.demo.school.h.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.demo.school.h.model.Student;
import ru.hogwarts.demo.school.h.repository.StudentRepository;

import java.util.Collection;

@Service

public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student findStudent(Long id) {
        return studentRepository.getById(id);
    }

    public Student editStudent(Student student) {
        return studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    public Collection<Student> findByAge(int age) {
        return studentRepository.findBy();
    }
}


