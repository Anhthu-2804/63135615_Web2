package com.example.qlbh_mypham.controllers;

import com.example.qlbh_mypham.models.SanPham;
import com.example.qlbh_mypham.services.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/sanpham")
public class SanPhamController {
    @Autowired
    SanPhamService sanPhamService;
    SanPham sanPham;
    List<SanPham> lst ;
    @GetMapping("/all")
    public String getAll(Model model){
        lst = sanPhamService.getAllSanPham();
        model.addAttribute("dsSanPham",lst);
        return "SanPhamView/danhsachSP";
    }

    @GetMapping("/findByName/{name}") // tim kiem theo ten
    public String findSanPhamByID(@PathVariable String name, Model model) {
         lst = sanPhamService.searchSanPhamByName(name);
        model.addAttribute("timKiemSP", lst);
        return "SanPhamView/timKiemSP";
    }

    @GetMapping("/danhmucSP")
    public String getALLCategory(Model model){

    }

}
