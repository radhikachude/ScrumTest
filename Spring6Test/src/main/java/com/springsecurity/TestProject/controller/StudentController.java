package com.springsecurity.TestProject.controller;

import com.springsecurity.TestProject.model.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

private List<Student> students= new ArrayList<>(List.of(
        new Student(1,"ram",60),
        new Student(2, "Shyam",70)
));

    @GetMapping("/test")
    public String testapi(HttpServletRequest httpRequest)
    {
        return "Welcome to Telusko...!"+httpRequest.getSession().getId();
    }
    @GetMapping("/student")
    public List<Student> getallstudentList()
    {
        return students;
    }
    @PostMapping("/student")
    public Student addStudent(Student student) {
        students.add(student);
        return student;
    }

    @GetMapping("/csrf-token")
    public CsrfToken csrfToken(HttpServletRequest request)
    {
       return (CsrfToken) request.getAttribute("_csrf");
    }
}
