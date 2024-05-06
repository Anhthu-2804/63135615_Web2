package com.example.qlbh_mypham.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity                        // đánh dấu rằng đây là một entity
@Table(name = "sanpham")
@Data
public class SanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MASANPHAM")
    private int id;

    @Column(name = "MALOAISANPHAM")
    private String maLoaiSP;

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

    @Override
    public String toString() {
        return "SanPham{" +
                "id=" + id +
                ", maLoaiSP='" + maLoaiSP + '\'' +
                ", name='" + name + '\'' +
                ", moTa='" + moTa + '\'' +
                ", donGia='" + donGia + '\'' +
                ", sl='" + sl + '\'' +
                ", hinhDang='" + hinhDang + '\'' +
                ", maNCC='" + maNCC + '\'' +
                ", thanhPhan='" + thanhPhan + '\'' +
                ", xuatXu='" + xuatXu + '\'' +
                ", img='" + img + '\'' +
                '}';
    }
}
