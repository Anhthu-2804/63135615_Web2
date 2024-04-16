package com.example.themsv.controllers;

import com.example.themsv.Models.SinhVien;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SinhVienController {
    @GetMapping("/themMoiSV")
    public String showForm(Model md){
        SinhVien sv = new SinhVien();
        md.addAttribute("sv",sv);
        return "themSVForm";
    }

    @PostMapping("/themMoiSV")
    public String submitForm(@ModelAttribute("sv") SinhVien sv) {
        return "themSInhVien_OK";
    }
}
