package com.example.qlbh_mypham.services.Impl;

import com.example.qlbh_mypham.models.SanPham;
import com.example.qlbh_mypham.repositories.SanPhamRepository;
import com.example.qlbh_mypham.services.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collections;
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
    public SanPham findSanPhamById(int id) {
        return sanPhamRepository.findById(id).orElse(null);
    }
    @Override
    public List<SanPham> getAllSanPham() {
        return sanPhamRepository.findAll();
    }
    @Override
    public List<SanPham> getAllSanPhamByLoaiSanPhamId(int loaiSP_ID){
        return sanPhamRepository.findSanPhamByLoaiSanPhamId(loaiSP_ID);
    } // liet ke ra san pham theo loai san pham

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

    @Override
    public Page<SanPham> findPaginated(Pageable pageable) {
        return sanPhamRepository.findAll(pageable);
    }

    @Override
    public SanPham getSanPhamById(int id) {
        Optional<SanPham> optionalSanPham = sanPhamRepository.findById(id);
        return optionalSanPham.orElse(null);
    }
}
