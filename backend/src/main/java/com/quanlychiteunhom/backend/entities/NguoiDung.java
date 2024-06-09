package com.quanlychiteunhom.backend.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "nguoi_dung")
@Getter
@Setter
public class NguoiDung {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ho_ten", nullable = false)
    private String hoTen;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "sdt", nullable = false, unique = true)
    private int sdt;

    @Column(name = "user_name", nullable = false, unique = true)
    private String userName;

    @Column(name = "passwork", nullable = false)
    private String passwork;

    @Column(name = "avatar")
    private String avatar;

    @OneToMany(mappedBy = "nguoiDung", fetch = FetchType.LAZY)
    private Set<ThanhVien> thanhViens;
}
