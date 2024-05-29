package com.quanlychiteunhom.backend.test.controller.request;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class ChiRequest {
    private Long id;
    private int soTien;
    private Date ngayChi;
    private String moTa;
    private int nhomId;


}
