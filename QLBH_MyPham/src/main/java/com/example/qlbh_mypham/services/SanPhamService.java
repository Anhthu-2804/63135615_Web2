package com.example.qlbh_mypham.services;

import com.example.qlbh_mypham.models.SanPham;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SanPhamService {
    List<SanPham> searchSanPhamByName(String name);
    List<SanPham> getAllSanPham();
    SanPham addSanPham(SanPham sanPham);
    void deleteSanPham(int id);
}