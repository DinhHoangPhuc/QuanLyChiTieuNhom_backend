package com.quanlychiteunhom.backend.test.controller.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "thanh_vien")
public class ThanhVien {

    public ThanhVien(int idnhom, int idnguoidung, int quyen) {
        this.idnhom = idnhom;
        this.idnguoidung = idnguoidung;
        this.quyen = quyen;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "id_nhom")
    private int idnhom;

    @Column(name = "id_nguoidung")
    private int idnguoidung;

    @Column(name = "quyen")
    private int quyen;

    // Default constructor is required by JPA
    public ThanhVien() {
    }
}