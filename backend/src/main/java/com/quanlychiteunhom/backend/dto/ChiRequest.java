package com.quanlychiteunhom.backend.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ChiRequest {

    private int soTien;

    private Date ngayChi;

    private String moTa;

    private int nhomId;
}
