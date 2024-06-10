package com.quanlychiteunhom.backend.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ThuRequest {
    private int soTien;
    private String moTa;
    private Date ngayThu;
    private int nhomId;
}
