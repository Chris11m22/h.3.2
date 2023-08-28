package ru.hogwarts.demo.school.h.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.hogwarts.demo.school.h.model.Avatar;
import ru.hogwarts.demo.school.h.model.Student;
import ru.hogwarts.demo.school.h.model.StudentsByCategory;
import ru.hogwarts.demo.school.h.repository.AvatarRepository;
import ru.hogwarts.demo.school.h.repository.StudentRepository;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.nio.file.StandardOpenOption.CREATE_NEW;


@Service

public class StudentService {
    @Value("${student.avatars.dir.path}")
    private String avatarDir;

    Logger logger = LoggerFactory.getLogger(StudentService.class);

    public StudentService(StudentRepository studentRepository, AvatarRepository avatarRepository) {
        this.studentRepository = studentRepository;
        this.avatarRepository = avatarRepository;
    }

    private final StudentRepository studentRepository;
    private final AvatarRepository avatarRepository;


    public Student addStudent(Student student) {
        logger.info("Was invoked method for add student");
        return studentRepository.save(student);
    }

    public Student findStudent(long id) {
        logger.info("Was invoked method for find student");
        return studentRepository.findById(id).get();
    }

    public Student editStudent(Student student) {
        logger.info("Was invoked method for edit student");
        return studentRepository.save(student);
    }

    public void deleteStudent(long id) {
        logger.info("Was invoked method for delete student");
        studentRepository.deleteById(id);
    }

    public Collection<Student> findByAge() {
        logger.info("Was invoked method for find student by age");
        return studentRepository.findAll();
    }

    public Collection<Student> findByAgeBetween(int minAge, int maxAge) {
        logger.info("Was invoked method for find age between");
        return studentRepository.findByAgeBetween(minAge, maxAge);

    }

    public Avatar findAvatar(long studentId) {
        logger.info("Was invoked method for find avatar");
        return avatarRepository.findByStudentId(studentId).orElseThrow();
    }

    public void uploadAvatar(Long studentId, MultipartFile avatarFile) throws IOException {
        logger.info("Was invoked method for upload avatar");
        Student student = findStudent(studentId);
        Path filePath = Path.of(avatarDir, student + "." + getExtensions(avatarFile.getOriginalFilename()));
        Files.createDirectories(filePath.getParent());
        Files.deleteIfExists(filePath);
        try (
                InputStream is = avatarFile.getInputStream();
                OutputStream os = Files.newOutputStream(filePath, CREATE_NEW);
                BufferedInputStream bis = new BufferedInputStream(is, 600);
                BufferedOutputStream bos = new BufferedOutputStream(os, 600)
        ) {
            bis.transferTo(bos);
        }
        Avatar avatar = findAvatar(studentId);
        avatar.setStudent(student);
        avatar.setFilePath(filePath.toString());
        avatar.setFileSize(avatarFile.getSize());
        avatar.setMediaType(avatarFile.getContentType());
        avatar.setData(avatarFile.getBytes());
        avatarRepository.save(avatar);
    }

    public Avatar findAvatar(Long studentId) {
        logger.info("Was invoked method for find avatar");
        logger.error("There is not avatar with id = " + studentId);
        return avatarRepository.findByStudentId(studentId).orElseThrow();

    }

    private String getExtensions(String fileName) {
        return fileName.substring(fileName.lastIndexOf(".") + 1);
    }

    public List<StudentsByCategory> getStudentsByCategory() {
        return studentRepository.getStudentsByCategory();
    }

    public List<Student> getStudentByAge(int age) {
        return studentRepository.getStudentByAge(age);
    }

    public List<Student> getStudentByName(String name) {
        return studentRepository.getStudentByName(name);
    }

    public Map<String, List<Student>> getNameAStream() {
        return studentRepository.findAll().stream()
                .filter(student -> student.getName().startsWith("A"))
                .collect(Collectors.groupingBy(Student::getName));
    }
    public double AgeOfStudentsStream() {
        return studentRepository.findAll().stream()
                .collect(
                        Collectors.averagingDouble(Student::getAge)
                );
    }

    public Integer tack4() {
        return Stream.iterate(1, a -> a + 1)
                .limit(1_000_000)
                .parallel()
                .reduce(0, Integer::sum);
    }

    public void getStudentOfStream() {
        var students = studentRepository.findAll()
                .stream()
                .limit(6)
                .collect(Collectors.toList());

        System.out.println(students.get(0));
        System.out.println(students.get(1));


        new Thread(() -> {
            System.out.println(students.get(2));
            System.out.println(students.get(3));

        }).start();

        new Thread(() -> {
            System.out.println(students.get(4));
            System.out.println(students.get(5));

        }).start();
    }

    public void getStudentOfStreamSync() {
        var students = studentRepository.findAll()
                .stream()
                .limit(6)
                .collect(Collectors.toList());

        print(students.get(0));
        print(students.get(1));


        new Thread(() -> {
            print(students.get(2));
            print(students.get(3));

        }).start();

        new Thread(() -> {
            print(students.get(4));
            print(students.get(5));

        }).start();
    }

    private synchronized void print(Object obj) {
        System.out.println(obj.toString());
    }
}





