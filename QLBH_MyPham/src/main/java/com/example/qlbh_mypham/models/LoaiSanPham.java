package com.example.qlbh_mypham.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity                        // đánh dấu rằng đây là một entity
@Table(name = "loaisanpham")
@Data
public class LoaiSanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MALOAISANPHAM")
    private int id;

    @Column(name = "TENLOAISANPHAM")
    private String name;
}
