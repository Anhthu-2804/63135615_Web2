package com.example.qlbh_mypham.services;

import com.example.qlbh_mypham.models.LoaiSanPham;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LoaiSanPhamService {
    List<LoaiSanPham> getAllLoaiSanPham();


}
