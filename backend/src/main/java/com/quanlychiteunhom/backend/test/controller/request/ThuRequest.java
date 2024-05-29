package com.quanlychiteunhom.backend.test.controller.request;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class ThuRequest {
    private Long id;
    private int soTien;
    private Date ngayThu;
    private String moTa;
    private int nhomId;

}