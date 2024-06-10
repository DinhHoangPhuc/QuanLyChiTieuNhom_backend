package com.quanlychiteunhom.backend.entities;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "lich_su_thu")
@Getter
@Setter
public class Thu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "so_tien")
    private int soTien;

    @Column(name = "mo_ta")
    private String moTa;

    @Column(name = "ngay_thu")
    private Date ngayThu;

    @ManyToOne
    @JoinColumn(name = "nhom_id")
    @JsonBackReference
    private Nhom nhom;
}
