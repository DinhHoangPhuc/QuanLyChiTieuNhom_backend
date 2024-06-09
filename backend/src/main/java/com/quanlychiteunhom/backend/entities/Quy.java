package com.quanlychiteunhom.backend.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "quy")
@Getter
@Setter
public class Quy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int nhomId;

    private int soTienBanDau;
    private int soTienHienTai;

    @OneToOne
    @JoinColumn(name = "nhom_id")
    private Nhom nhom;
}
