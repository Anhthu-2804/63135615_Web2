package com.example.qlbh_mypham.services.Impl;

import com.example.qlbh_mypham.models.LoaiSanPham;
import com.example.qlbh_mypham.repositories.LoaiSanPhamRepository;
import com.example.qlbh_mypham.services.LoaiSanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoaiSanPhamServiceImpl implements LoaiSanPhamService {
    @Autowired
    private LoaiSanPhamRepository loaiSanPhamRepository;
    @Override
    public List<LoaiSanPham> getAllLoaiSanPham() {
        return loaiSanPhamRepository.findAll();
    }

}
