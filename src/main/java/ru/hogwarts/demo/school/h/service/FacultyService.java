package ru.hogwarts.demo.school.h.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.demo.school.h.model.Faculty;
import ru.hogwarts.demo.school.h.model.Student;
import ru.hogwarts.demo.school.h.repository.FacultyRepository;


import java.util.Collection;
import java.util.List;


@Service
public class FacultyService {
    private final FacultyRepository facultyRepository;

    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public Faculty addFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    public Faculty findFaculty(long id) {
        return facultyRepository.findById(id).get();
    }


    public Faculty editFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }


    public void deleteFaculty(long id) {
        facultyRepository.deleteById(id);
    }

    public Collection<Faculty> findByColor() {
        return facultyRepository.findAll();
    }

    public Collection<Faculty> findByColor(String color) {
        return facultyRepository.findByColorIgnoreCase(color);
    }

    public Collection<Faculty> findByName(String name) {
        return facultyRepository.findByNameIgnoreCase(name);
    }
    public Collection<Student> findAllStudentsByFaculty_Id(Long id){
        return facultyRepository.findAllStudentsByFaculty_Id(id);
    }
    public List<Student> getStudentByCAndF(String color, String faculty) {
        return facultyRepository.getStudentByCAndF(color, faculty);
    }
}

