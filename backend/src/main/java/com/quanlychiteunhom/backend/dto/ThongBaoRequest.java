package com.quanlychiteunhom.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class ThongBaoRequest {
    private String tieude;
    private String noiDung;
    private Date ngaydang;
    private int nhomid;
}
