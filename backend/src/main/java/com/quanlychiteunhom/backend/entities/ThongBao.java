package com.quanlychiteunhom.backend.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "thong_bao")
public class ThongBao {
    public ThongBao(String tieude, String noidung, Date ngaydang, int idnhom) {
        this.tieude = tieude;
        this.noidung = noidung;
        this.ngaydang = ngaydang;
        this.idnhom = idnhom;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "tieu_de")
    private String tieude;

    @Column(name = "noi_dung")
    private String noidung;

    @Column(name = "ngay_dang")
    private Date ngaydang;

    @Column(name = "nhom_id")
    private int idnhom;
    // Default constructor is required by JPA
    public ThongBao() {
    }
}
