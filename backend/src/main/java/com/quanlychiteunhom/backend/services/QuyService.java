package com.quanlychiteunhom.backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quanlychiteunhom.backend.entities.Quy;
import com.quanlychiteunhom.backend.entities.ThanhVien;
import com.quanlychiteunhom.backend.repositories.QuyRepo;
import com.quanlychiteunhom.backend.repositories.ThanhVienRepo;
@Service
public class QuyService {
    @Autowired
    private QuyRepo quyRepo;
    private ThanhVienRepo thanhVienRepo;

    // public ResponseEntity<List<Quy>> getQuy() {
    //     try {
    //         List<Quy> quy = quyRepo.findAll();
    //         return new ResponseEntity<>(quy, HttpStatus.OK);
    //     } catch (Exception e) {
    //         return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    //     }
    // }
    public double chiaDeuTien(int nhomId) {
        Quy quy = quyRepo.findById(nhomId).orElseThrow(() -> new RuntimeException("Nhóm không tồn tại"));
        List<ThanhVien> thanhVienList = thanhVienRepo.findByNhomId(nhomId);

        if (thanhVienList.isEmpty()) {
            throw new RuntimeException("Không có thành viên nào trong nhóm");
        }

        int soThanhVien = thanhVienList.size();
        double soTienMoiThanhVien = quy.getSoTienHT() / (double) soThanhVien;

        return soTienMoiThanhVien;
    }
}
