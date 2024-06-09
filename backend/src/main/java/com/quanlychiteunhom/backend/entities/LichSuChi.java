package com.quanlychiteunhom.backend.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "lich_su_chi")
@Getter
@Setter
public class LichSuChi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "so_tien", nullable = false)
    private int soTien;

    @Column(name = "ngay_chi", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date ngayThu;

    @Column(name = "mo_ta", length = 1000, nullable = false)
    private String moTa;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nhom_id", nullable = false)
    private Nhom nhom;

}
