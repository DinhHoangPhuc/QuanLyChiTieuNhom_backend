package com.quanlychiteunhom.backend.test.controller.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "thanh_vien")
@Getter
@Setter
public class ThanhVien {
    public ThanhVien() {
    }
    public ThanhVien(int nhomId, int nguoiDungId, int quyen) {
        this.nhomId = nhomId;
        this.nguoiDungId = nguoiDungId;
        this.quyen = quyen;
    }
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nhom_id")
    private int nhomId;

    @Column(name = "nguoi_dung_id")
    private int nguoiDungId;

    @Column(name = "quyen")
    private int quyen;
}