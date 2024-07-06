package com.quanlychiteunhom.backend.services;

import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public interface TinhTienService {
    Map<String, Double> tinhTienChiaDeu(int nhomId);
    Map<String, Double> soTienHienTai(int nhomId);
}
