package com.example.qlbh_mypham.controllers;

import com.example.qlbh_mypham.models.LoaiSanPham;
import com.example.qlbh_mypham.models.SanPham;
import com.example.qlbh_mypham.services.LoaiSanPhamService;
import com.example.qlbh_mypham.services.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/sanpham")
public class SanPhamController {
    @Autowired
    SanPhamService sanPhamService;
    LoaiSanPhamService loaiSanPhamService;
    List<SanPham> sanPhamList;
    List<LoaiSanPham> loaiSanPhamList;

    @GetMapping("/all")
    public String getAll(Model model) { // lay toan bo san pham
        sanPhamList = sanPhamService.getAllSanPham();
        model.addAttribute("dsSanPham", sanPhamList);
        return "SanPhamView/danhsachSP";
    }

    @GetMapping("/findByName") // tim kiem theo ten
    public String findSanPhamByID(@RequestParam("name") String name, Model model) {
        sanPhamList = sanPhamService.searchSanPhamByName(name);
        model.addAttribute("timKiemSP", sanPhamList);
        return "SanPhamView/timKiemSP";
    }


    @GetMapping("/sanPhamTheoLoai/{id}")
    public String getALLSanPhamByLoaiSanPham(Model model, @PathVariable int id) {
        sanPhamList = sanPhamService.getAllSanPhamByLoaiSanPhamId(id);
        model.addAttribute("dsSPTheoLoai", sanPhamList);
        return "SanPhamView/dsSanPhamTheoLoai";
    }

    @GetMapping("/phantrang")
    public String viewSanPhamPage(Model model,
                                  @RequestParam(defaultValue = "0") int page) {
        int pageSize = 10; // số lượng sản phẩm mỗi trang
        Pageable pageable = PageRequest.of(page, pageSize);
        Page<SanPham> sanPhamPage = sanPhamService.findPaginated(pageable);

        model.addAttribute("sanPhamPage", sanPhamPage);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", sanPhamPage.getTotalPages());

        return "SanPhamView/phantrang";
    }

    @GetMapping("/chitietsanpham/{id}")
    public String getChiTietSanPham(@PathVariable("id") int id, Model model) {
        SanPham sanPham = sanPhamService.getSanPhamById(id);
        model.addAttribute("sanPham", sanPham);
        return "chitietSanPham";
    }

    @GetMapping("/index")
    public String index() {
        return "index";
    }

}
