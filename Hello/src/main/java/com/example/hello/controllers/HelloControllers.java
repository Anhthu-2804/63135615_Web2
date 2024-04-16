package com.example.hello.controllers;


import org.springframework.ui.Model;
import com.example.hello.models.SinhVien;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;



@Controller
public class HelloControllers {
    @GetMapping("/hello")
    public String index(){
        return "index";
    }

    List<SinhVien> lst = new ArrayList<>();

    {
        lst.add(new SinhVien("1","thu"));
        lst.add(new SinhVien("2","giang"));
    }

    @GetMapping("/dssv")
    public String listStudent(Model model){
        model.addAttribute("lst", lst);
        return "sinhVien_getAll";
    }
}
