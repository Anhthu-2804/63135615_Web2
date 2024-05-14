package com.example.qlbh_mypham.services;

import com.example.qlbh_mypham.models.KhachHang;
import com.example.qlbh_mypham.models.SanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface KhachHangService  {
    List<KhachHang> findAllSanPham();
    SanPham findSanPhamByID(int id);
    SanPham addSanPham(SanPham sanPham);
    void deleteSanPham(int id);
}
