package com.example.demo.student;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Controller
@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {
    @GetMapping
    public List<Student> getStudents(){

        return List.of(new Student(1L,"anhthu","anhthu@gmail.com",
                LocalDate.of(2000, Month.APRIL, 5), 18
        ));

    }
}
