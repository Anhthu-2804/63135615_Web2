package com.example.qlbh_mypham.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


public class GioHangItem {

    private SanPham sanPham;
    private int soLuong;
    private BigDecimal tongGia;
    private boolean selected;


    public GioHangItem(SanPham sanPham, int soLuong) {
        this.sanPham = sanPham;
        this.soLuong = soLuong;
        this.tongGia = sanPham.getDonGia().multiply(BigDecimal.valueOf(soLuong)); // chuyen doi soLuong thanh BigDecimal va nhan voi don gia
        this.selected = false;
    }
public void updateTongGia(){
        tongGia = sanPham.getDonGia().multiply(BigDecimal.valueOf(soLuong));
}
// Getters and Setters

    public SanPham getSanPham() {
        return sanPham;
    }

    public void setSanPham(SanPham sanPham) {
        this.sanPham = sanPham;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
        updateTongGia();
    }

    public BigDecimal getTongGia() {
        return tongGia;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

}
