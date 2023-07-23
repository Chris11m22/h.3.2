package ru.hogwarts.demo.school.h.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.demo.school.h.model.Faculty;
import ru.hogwarts.demo.school.h.repository.FacultyRepository;

import java.util.Collection;

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
        return facultyRepository.getById(id);
    }

    public Faculty editFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    public void deleteFaculty(long id) {
        facultyRepository.deleteById(id);
    }

    public Collection<Faculty> findByColor(String color) {
        return facultyRepository.findBy();

    }

}

