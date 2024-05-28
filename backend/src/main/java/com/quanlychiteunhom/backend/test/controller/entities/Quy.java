package com.quanlychiteunhom.backend.test.controller.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "quy")
@Getter
@Setter
public class Quy {
    public Quy(){
    }
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "so_tien_ban_dau")
    private int soTienBanDau;

    @Column(name = "so_tien_hien_tai")
    private int soTienHienTai;

}
