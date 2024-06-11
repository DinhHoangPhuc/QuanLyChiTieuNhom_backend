package com.quanlychiteunhom.backend.dto;

import java.math.BigDecimal;
// import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
// @AllArgsConstructor
@NoArgsConstructor
public class ChiTuanStats {
    private LocalDate ngayChi;
    private BigDecimal soTien;

    public ChiTuanStats(LocalDate result, BigDecimal result2) {
        this.ngayChi = result;
        this.soTien = result2;
    }

    // public ChiTuanStats() {

    // }

}
