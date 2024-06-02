package com.example.qlbh_mypham.services;

import com.example.qlbh_mypham.models.GioHang;
import com.example.qlbh_mypham.models.GioHangItem;
import com.example.qlbh_mypham.models.SanPham;
import com.example.qlbh_mypham.repositories.SanPhamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.List;

@Service
@SessionScope
public class GioHangService {
    @Autowired
    private SanPhamRepository sanPhamRepository;
    private GioHang gioHang = new GioHang();

    public GioHang getGioHang() {
        return gioHang;
    }

    public void addSanPham(SanPham sanPham, int soLuong) {
        for (GioHangItem item : gioHang.getItems()) {
            if (item.getSanPham().getId() == sanPham.getId()) {
                item.setSoLuong(item.getSoLuong() + soLuong);
                item.updateTongGia();
                gioHang.calculateTotal();
                return;
            }
        }
        GioHangItem newItem = new GioHangItem(sanPham, soLuong);
        gioHang.addItem(newItem);
        gioHang.calculateTotal();
    }

    public void removeSanPham(int id) {
        GioHangItem itemToRemove = null;
        for (GioHangItem item : gioHang.getItems()) {
            if (item.getSanPham().getId() == id) {
                itemToRemove = item;
                break;
            }
        }
        if (itemToRemove != null) {
            gioHang.removeItem(itemToRemove);
            gioHang.calculateTotal();
        }
    }

    public void updateSanPham(List<Integer> productIds, List<Integer> soLuong, List<Integer> dsSelectedItems) {
        for (int i = 0; i < productIds.size(); i++) {
            SanPham sanPham = sanPhamRepository.findById(productIds.get(i)).orElse(null);
            if (sanPham != null) {
                gioHang.updateItem(sanPham, soLuong.get(i));
            }
        }
        for (GioHangItem item : gioHang.getItems()) {
            item.setSelected(dsSelectedItems.contains(item.getSanPham().getId()));
        }
        gioHang.calculateTotal();
    }

    public void clearGioHang() {
        gioHang.clear();
    }
}
