package com.quanlychiteunhom.backend.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quanlychiteunhom.backend.entities.Quy;
import com.quanlychiteunhom.backend.entities.ThanhVien;
import com.quanlychiteunhom.backend.repositories.QuyRepo;
import com.quanlychiteunhom.backend.repositories.ThanhVienRepo;
@Service
public interface TinhTienService {
    Map<String, Double> tinhTienChiaDeu(int nhomId);
    Map<String, Double> soTienHienTai(int nhomId);
}
