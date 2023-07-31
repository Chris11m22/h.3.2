package ru.hogwarts.demo.school.h;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import ru.hogwarts.demo.school.h.controller.FacultyController;
import ru.hogwarts.demo.school.h.controller.StudentController;
import ru.hogwarts.demo.school.h.model.Faculty;
import ru.hogwarts.demo.school.h.model.Student;
import ru.hogwarts.demo.school.h.repository.AvatarRepository;
import ru.hogwarts.demo.school.h.repository.FacultyRepository;
import ru.hogwarts.demo.school.h.repository.StudentRepository;
import ru.hogwarts.demo.school.h.service.AvatarService;
import ru.hogwarts.demo.school.h.service.FacultyService;
import ru.hogwarts.demo.school.h.service.StudentService;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class StudentWebMvcTest {


    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private StudentRepository studentRepository;
    @MockBean
    private AvatarRepository avatarRepository;
    @SpyBean
    private StudentService studentService;
    @SpyBean
    private AvatarService avatarService;
    @InjectMocks
    private StudentController studentController;

    @Test
    public void saveStudentTest() throws Exception {
        JSONObject studentObject = new JSONObject();
       studentObject.put("name", "11");
        Student student = new Student();
       student.setId(5);
        student.setName("name");
       student.setAge(9);
        when(studentRepository.save(any(Student.class))).thenReturn(student);
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/student")
                        .content(studentObject.toString())
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("id"))
                .andExpect(jsonPath("$.name").value("name"))
                .andExpect(jsonPath("$.age").value("age"));

    }
}
