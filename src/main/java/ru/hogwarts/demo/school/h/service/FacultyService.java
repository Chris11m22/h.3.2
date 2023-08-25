package ru.hogwarts.demo.school.h.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.hogwarts.demo.school.h.model.Faculty;
import ru.hogwarts.demo.school.h.model.Student;
import ru.hogwarts.demo.school.h.repository.FacultyRepository;


import java.util.Collection;
import java.util.List;


@Service
public class FacultyService {
    private final FacultyRepository facultyRepository;
    Logger logger = LoggerFactory.getLogger(StudentService.class);

    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public Faculty addFaculty(Faculty faculty) {
        logger.info("Was invoked method for add faculty");
        return facultyRepository.save(faculty);
    }

    public Faculty findFaculty(long id) {
        logger.info("Was invoked method for find faculty");
        return facultyRepository.findById(id).get();
    }


    public Faculty editFaculty(Faculty faculty) {
        logger.info("Was invoked method for edit faculty");
        return facultyRepository.save(faculty);
    }


    public void deleteFaculty(long id) {
        logger.info("Was invoked method for delete faculty");
        facultyRepository.deleteById(id);
    }

    public Collection<Faculty> findByColor() {
        logger.info("Was invoked method for find by color");
        return facultyRepository.findAll();
    }

    public Collection<Faculty> findByColor(String color) {
        return facultyRepository.findByColorIgnoreCase(color);
    }

    public Collection<Faculty> findByName(String name) {
        logger.info("Was invoked method for find by name");
        return facultyRepository.findByNameIgnoreCase(name);
    }
    public Collection<Student> findAllStudentsByFaculty_Id(Long id){
        logger.info("Was invoked method for find by faculty id");
        return facultyRepository.findAllStudentsByFaculty_Id(id);
    }
    public List<Student> getStudentByCAndF(String color, String faculty) {
        logger.info("Was invoked method for get student");
        return facultyRepository.getStudentByCAndF(color, faculty);
    }
}

