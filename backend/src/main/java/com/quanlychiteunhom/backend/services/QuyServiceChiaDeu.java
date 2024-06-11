package com.quanlychiteunhom.backend.services;

import org.springframework.stereotype.Service;

@Service
public interface QuyServiceChiaDeu {
    double tinhTienChiaDeu(int nhomId);
    double soTienHienTai(int nhomId);
}
