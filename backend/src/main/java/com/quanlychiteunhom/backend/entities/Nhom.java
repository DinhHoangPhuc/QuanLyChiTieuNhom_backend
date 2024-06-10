package com.quanlychiteunhom.backend.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "nhom")
@Getter
@Setter
public class Nhom {

    public Nhom() {
    }

    public Nhom(String tenNhom, String hinhNhom) {
        this.tenNhom = tenNhom;
        this.hinhNhom = hinhNhom;
    }

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "ten_nhom")
    private String tenNhom;

    @Column(name = "mo_ta")
    private String moTa;

    @Column(name = "hinh_nhom")
    private String hinhNhom;
}
