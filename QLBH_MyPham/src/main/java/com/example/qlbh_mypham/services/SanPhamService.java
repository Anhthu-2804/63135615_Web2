package com.example.qlbh_mypham.services;

import com.example.qlbh_mypham.models.SanPham;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SanPhamService {
    List<SanPham> searchSanPhamByName(String name);
    List<SanPham> getAllSanPham();
    List<SanPham> getAllSanPhamByLoaiSanPhamId(int loaiSP_ID);
    SanPham addSanPham(SanPham sanPham);
    void deleteSanPham(int id);
    public Page<SanPham> findPaginated(Pageable pageable);
}
