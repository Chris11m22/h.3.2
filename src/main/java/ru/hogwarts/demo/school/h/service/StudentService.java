package ru.hogwarts.demo.school.h.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.demo.school.h.model.Faculty;
import ru.hogwarts.demo.school.h.model.Student;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Objects;

@Service

public class StudentService {
    private final HashMap<Long, Student> students = new HashMap();
    private long count = 0;

    public Student addStudent(Student student) {
        student.setId(count++);
        students.put(student.getId(), student);
        return student;
    }

    public Student findStudent(Long id) {
        return students.get(id);
    }

    public Student editStudent(Student student) {
        if (!students.containsKey(student.getId())) {
            return null;
        }
        students.put(student.getId(), student);
        return student;
    }

    public Student deleteStudent(Long id) {
        return students.remove(id);
    }

    public Collection<Student> findByAge(int age) {
        ArrayList<Student> result = new ArrayList<>();
        for (Student student : students.values()) {
            if (student.getAge() == age) {
                result.add(student);
            }
        }
        return result;
    }
}


