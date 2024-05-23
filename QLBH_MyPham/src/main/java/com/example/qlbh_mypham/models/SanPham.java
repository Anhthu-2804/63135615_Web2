package com.example.qlbh_mypham.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sanpham")
@Data
public class SanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MASANPHAM")
    private int id;

    @Column(name = "TENSP")
    private String name;

    @Column(name = "MOTA")
    private String moTa;

    @Column(name = "DONGIA")
    private String donGia;

    @Column(name = "SOLUONG")
    private String sl;

    @Column(name = "HINHDANG")
    private String hinhDang;

    @Column(name = "MANCC")
    private String maNCC;

    @Column(name = "THANHPHAN")
    private String thanhPhan;

    @Column(name = "XUATXU")
    private String xuatXu;

    @Column(name = "HINHANH")
    private String img;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MALOAISANPHAM", referencedColumnName = "MALOAISANPHAM")
    private LoaiSanPham loaiSanPham;
}
