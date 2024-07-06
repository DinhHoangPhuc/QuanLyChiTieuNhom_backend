package com.quanlychiteunhom.backend.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ChiTuanStats {
    private LocalDate ngayChi;
    private BigDecimal soTien;

    public ChiTuanStats(LocalDate result, BigDecimal result2) {
        this.ngayChi = result;
        this.soTien = result2;
    }

}
