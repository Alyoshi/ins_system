package com.example.demo.student;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {
    private final StudentService studentService;
    // Konstruktor, nimmt StudentService. Dieser wird mit @Autowired annotiert, um die Abhängigkeit zu injizieren. Muss mit @Component annotiert sein.
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    //Was passiert bei get
    @GetMapping()
    public List<Student> getStudents() {
        return studentService.getStudents();
    }
    @PostMapping()
    public void registerNewStudent(@RequestBody Student student) {
        studentService.addNewStudent(student);
    }
}
