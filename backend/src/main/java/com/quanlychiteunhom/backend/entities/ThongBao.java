package com.quanlychiteunhom.backend.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "thong_bao")
@Getter
@Setter
public class ThongBao {


    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "tieu_de")
    private String tieude;

    @Column(name = "noi_dung")
    private String noiDung;

    @Column(name = "ngay_dang")
    private Date ngaydang;

    @ManyToOne
    @JoinColumn(name = "nhom_id")
    @JsonBackReference
    private Nhom nhom;
}
