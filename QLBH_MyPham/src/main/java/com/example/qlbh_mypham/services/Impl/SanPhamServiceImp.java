package com.example.qlbh_mypham.services.Impl;

import com.example.qlbh_mypham.models.SanPham;
import com.example.qlbh_mypham.repositories.SanPhamRepository;
import com.example.qlbh_mypham.services.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class SanPhamServiceImp implements SanPhamService {
    @Autowired
    SanPhamRepository sanPhamRepository;

    @Override
    public List<SanPham> searchSanPhamByName(String name) {
        return sanPhamRepository.findByNameContainingIgnoreCase(name); // tim kiem theo ten san pham, k phan biet hoa
    }

    @Override
    public List<SanPham> getAllSanPham() {
        return sanPhamRepository.findAll();
    }

//    @Override
//    public SanPham findSanPhamByID(int id) {
//        Optional<SanPham> opt = sanPhamRepository.findById( id);
//        if (opt.isPresent())
//            return opt.get();
//        else
//            return null;
//    }

    @Override
    public SanPham addSanPham(SanPham sanPham) {
        return sanPhamRepository.save(sanPham);
    }

    @Override
    public void deleteSanPham(int id) {
        Optional<SanPham> sanPhamOptional = sanPhamRepository.findById(id);
        if (sanPhamOptional.isPresent()){
            sanPhamRepository.deleteById(id);
        }
        else {
            throw new RuntimeException("Không thể xóa sản phẩm. ID không tồn tại trong danh sách sản phẩm.");
        }
    }
}
