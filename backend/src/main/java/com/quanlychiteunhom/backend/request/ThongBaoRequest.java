package com.quanlychiteunhom.backend.request;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ThongBaoRequest {
    private String tieude;
    private String noidung;
    private Date ngaydang;
    private int idnhom;
}
