package ru.hogwarts.demo.school.h.controller;


import org.springframework.data.jpa.domain.JpaSort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.hogwarts.demo.school.h.model.Avatar;
import ru.hogwarts.demo.school.h.model.Student;
import ru.hogwarts.demo.school.h.service.AvatarService;
import ru.hogwarts.demo.school.h.service.StudentService;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;
import java.util.Collections;


@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("{id}")
    public ResponseEntity<Student> getStudentInfo(@PathVariable Long id) {
        Student student = studentService.findStudent(id);
        if (student == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student);
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @PutMapping
    public ResponseEntity<Student> editStudent(@RequestBody Student student) {
        Student foundStudent = studentService.editStudent(student);
        if (foundStudent == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(foundStudent);
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Collection<Student>> findStudents(@RequestParam(required = false) int age) {
        if (age > 0) {
            return ResponseEntity.ok(studentService.findByAge());
        }
        return ResponseEntity.ok(Collections.emptyList());
    }
    @GetMapping(value = "/{id}/avatar",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> uploadAvatar(@PathVariable long id, @RequestParam MultipartFile avatar) throws IOException {
        if (avatar.getSize() >= 600 * 600) {
            return ResponseEntity.badRequest().body("File is to small");
        }
        studentService.uploadAvatar(id, avatar);
        return ResponseEntity.ok().build();
    }
    @GetMapping(value = "/{id}/avatar" )
    public ResponseEntity<Long> downloadAvatar(@PathVariable Long id){
        Avatar avatar = studentService.findAvatar(id);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType(avatar.getMediaType()));
        headers.setContentLength(avatar.getFileSize());

        return ResponseEntity.status(HttpStatus.OK).header(String.valueOf(headers)).body(avatar.getFileSize());
    }
    @GetMapping(value = "/{id}/avatar" )
    public void downloadAvatar(@PathVariable Long id, HttpServletResponse response) throws IOException{
        Avatar avatar = studentService.findAvatar(id);
        Path path = Path.of(avatar.getFilePath());
        try (InputStream is = Files.newInputStream(path);
        OutputStream os = response.getOutputStream();) {
            response.setContentType(avatar.getMediaType());
            response.setContentLength((int) avatar.getFileSize());
            is.transferTo(os);

        }
    }


}