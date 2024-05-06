package com.example.qlbh_mypham.controllers;

import com.example.qlbh_mypham.models.SanPham;
import com.example.qlbh_mypham.services.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/sanpham")
public class SanPhamController {
    @Autowired
    SanPhamService sanPhamService;
    @GetMapping("/all")
    public String getAll(Model model){
        List<SanPham> lst = sanPhamService.findAllSanPham();
        model.addAttribute("dsSanPham",lst);
        return "danhsachSP";
    }
}
