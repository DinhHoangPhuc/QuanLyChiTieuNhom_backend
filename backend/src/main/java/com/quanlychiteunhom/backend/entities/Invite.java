package com.quanlychiteunhom.backend.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Invite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "nhom_id")
    private Nhom nhom;

    @ManyToOne
    @JoinColumn(name = "inviter_id")
    private NguoiDung nguoiDung;

    @Column(name = "token")
    private String token;

    @Column(name = "expiry_at")
    private Date expiryAt;

    @Column(name = "max_uses")
    private int maxUses;

    @Column(name = "used_count")
    private int usedCount;
}
