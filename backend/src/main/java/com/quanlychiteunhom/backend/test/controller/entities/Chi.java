package com.quanlychiteunhom.backend.test.controller.entities;

import java.sql.Date;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "lich_su_chi")
@Getter
@Setter
public class Chi {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="so_tien")
    private int soTien;
    @Column(name = "ngay_chi")
    private Date ngayChi;
    @Column(name = "mo_ta")
    private String moTa;
    @Column(name = "nhom_id")
    private int nhomId;

    public Chi() {
    }

    public Chi(Long id, int soTien, Date ngayChi, String moTa, int nhomId) {
        this.id = id;
        this.soTien = soTien;
        this.ngayChi = ngayChi;
        this.moTa = moTa;
        this.nhomId = nhomId;
    }


}
