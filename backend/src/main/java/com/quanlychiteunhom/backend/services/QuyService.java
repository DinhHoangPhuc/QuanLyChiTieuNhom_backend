package com.quanlychiteunhom.backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quanlychiteunhom.backend.entities.Quy;
import com.quanlychiteunhom.backend.entities.ThanhVien;
import com.quanlychiteunhom.backend.repositories.QuyRepo;
import com.quanlychiteunhom.backend.repositories.ThanhVienRepo;
@Service
public interface QuyService {
    double tinhTienChiaDeu(int nhomId);
    double soTienHienTai(int nhomId);
}
