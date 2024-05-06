package com.example.qlbh_mypham.services;

import com.example.qlbh_mypham.models.SanPham;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SanPhamService {
    List<SanPham> findAllSanPham();
    SanPham findSanPhamByID(int id);
    void addSanPham(SanPham sanPham);
    void deleteSanPham(int id);
}
