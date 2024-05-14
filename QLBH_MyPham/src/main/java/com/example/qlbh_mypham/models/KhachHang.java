package com.example.qlbh_mypham.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity                        // đánh dấu rằng đây là một entity
@Table(name = "khachhang")
@Data
public class KhachHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MAKHACHHANG")
    private int id;

    @Column(name = "TENKHACHHANG")
    private String name;

    @Column(name = "DIENTHOAI")
    private String number;

    @Column(name = "GIOITINH")
    private String sex;

    @Column(name = "DIACHI")
    private String address;

    @Column(name = "TICHDIEM")
    private int score;

    @Column(name = "MALOAIKH")
    private int maLKH;
}
