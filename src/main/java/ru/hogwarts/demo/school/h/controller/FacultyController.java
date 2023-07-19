package ru.hogwarts.demo.school.h.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.demo.school.h.model.Faculty;
import ru.hogwarts.demo.school.h.service.FacultyService;

@RestController
    public class FacultyController {

    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

}
