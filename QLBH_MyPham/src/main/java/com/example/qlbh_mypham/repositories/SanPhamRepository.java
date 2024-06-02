package com.example.qlbh_mypham.repositories;

import com.example.qlbh_mypham.models.SanPham;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SanPhamRepository extends JpaRepository<SanPham, Integer> {
    List<SanPham> findByNameContainingIgnoreCase(String name); // tim kiem theo ten san pham
    List<SanPham> findSanPhamByLoaiSanPhamId(int loaiSP_Id);
    Page<SanPham> findAll(Pageable pageable);

}
