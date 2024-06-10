package com.quanlychiteunhom.backend.dto;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ChiRequest {

    private int soTien;

    private Date ngayChi;

    private String moTa;

    private int nhomId;
}
