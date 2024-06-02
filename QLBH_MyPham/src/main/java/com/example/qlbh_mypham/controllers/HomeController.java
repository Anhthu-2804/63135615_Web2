package com.example.qlbh_mypham.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class HomeController {
    @GetMapping("/")
    public String home() {
        return "Home"; // Tên của file template Thymeleaf cho trang chủ
    }
}
