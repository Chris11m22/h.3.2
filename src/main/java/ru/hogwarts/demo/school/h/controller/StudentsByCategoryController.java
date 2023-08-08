package ru.hogwarts.demo.school.h.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.hogwarts.demo.school.h.model.StudentsByCategory;
import ru.hogwarts.demo.school.h.service.StudentService;

import java.util.List;

@RestController

public class StudentsByCategoryController {

    private final StudentService studentService;

    public StudentsByCategoryController(StudentService studentService) {
        this.studentService = studentService;
    }
    @GetMapping
    public List<StudentsByCategory> getStudentsByCategory(){
        return studentService.getStudentsByCategory();

    }
}
