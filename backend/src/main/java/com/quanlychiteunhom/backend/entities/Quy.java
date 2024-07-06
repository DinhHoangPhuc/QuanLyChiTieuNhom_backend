package com.quanlychiteunhom.backend.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "quy")
@Getter
@Setter
public class Quy {

    public Quy() {
    }

    public Quy(int soTienBD, int soTienHT) {
        this.soTienBD = soTienBD;
        this.soTienHT = soTienHT;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "so_tien_ban_dau")
    private int soTienBD;

    @Column(name = "so_tien_hien_tai")
    private int soTienHT;

    @OneToOne
    @JoinColumn(name = "nhom_id", unique = true)
    @JsonManagedReference
    private Nhom nhom;

    @OneToMany(mappedBy = "quy")
    @JsonManagedReference
    private List<Chi> chis;

    @OneToMany(mappedBy = "quy")
    @JsonManagedReference
    private List<Thu> thus;
}
