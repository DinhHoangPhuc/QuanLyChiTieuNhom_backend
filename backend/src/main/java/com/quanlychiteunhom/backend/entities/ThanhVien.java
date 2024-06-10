package com.quanlychiteunhom.backend.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "thanh_vien")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ThanhVien {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "nhom_id")
    @JsonBackReference
    private Nhom nhom;

    @ManyToOne
    @JoinColumn(name = "nguoi_dung_id")
    @JsonBackReference
    private NguoiDung nguoiDung;

    @Column(name = "quyen")
    private int quyen;
}