package com.quanlychiteunhom.backend.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "lich_su_thu")
@Getter
@Setter
public class LichSuThu {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "mo_ta")
    private String moTa;

    @Column(name = "ngay_thu")
    private Date ngayChi;

    @Column(name="so_tien", nullable = false)
    private Integer soTien;

    @Column(name = "nhom_id", nullable = false)
    private Integer nhomId;

    public LichSuThu(){

    }

    public LichSuThu(Long id, String moTa, Date ngayChi, Integer soTien, Integer nhomId) {
        this.id = id;
        this.moTa = moTa;
        this.ngayChi = ngayChi;
        this.soTien = soTien;
        this.nhomId = nhomId;
    }
}
