package com.example.qlbh_mypham.services;

import com.example.qlbh_mypham.models.SanPham;
import com.example.qlbh_mypham.repositories.SanPhamRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class SanPhamServiceImp implements SanPhamService {
    @Autowired
    SanPhamRepository sanPhamRepository;
    @Override
    public List<SanPham> findAllSanPham() {
        return sanPhamRepository.findAll(); // phuong thuc findAll() co san dung de laay tat ca ban ghi sanpham
    }

    @Override
    public SanPham findSanPhamByID(int id) {
        Optional<SanPham> optionalSanPham = sanPhamRepository.findById(id);
        if (optionalSanPham.isPresent() ){
            System.out.println("Tên khách hàng: " );
            return optionalSanPham.get();
        }
        return null;
    }

    @Override
    public void addSanPham(SanPham sanPham) {

    }

    @Override
    public void deleteSanPham(int id) {

    }
}
