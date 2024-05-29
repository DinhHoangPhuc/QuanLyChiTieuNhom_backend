package com.quanlychiteunhom.backend.test.controller.entities;

import java.sql.Date;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table (name = "lich_su_thu")
@Getter
@Setter
public class Thu {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "so_tien")
    private int soTien;
    @Column(name="ngay_thu")
    private Date ngayThu;
    @Column(name = "mo_ta")
    private String moTa;
    @Column(name="nhom_id")
    private int nhomId;
    
    public Thu() {
    }

    public Thu(Long id, int soTien, String moTa, Date ngayThu, int nhomId) {
        this.id = id;
        this.soTien = soTien;
        this.moTa = moTa;
        this.ngayThu = ngayThu;
        this.nhomId = nhomId;
    }


}
