package com.quanlychiteunhom.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class NhomRequest {
    private String tenNhom;
    private String moTa;
    private String hinhNhom;
}
