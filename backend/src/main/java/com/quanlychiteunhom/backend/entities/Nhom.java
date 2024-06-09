package com.quanlychiteunhom.backend.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "nhom")
@Getter
@Setter
public class Nhom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "ten_nhom")
    private String tenNhom;

    @Column(name = "mo_ta", nullable = false)
    private String moTa;

    @Column(name = "hinh_nhom")
    private String hinhNhom;

    @OneToMany(mappedBy = "nhom", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<ThanhVien> thanhViens;

    @OneToOne(mappedBy = "nhom", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Quy quy;

    @OneToMany(mappedBy = "nhom", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<LichSuChi> lichSuChis;

    @OneToMany(mappedBy = "nhom", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<LichSuThu> lichSuThus;
}
