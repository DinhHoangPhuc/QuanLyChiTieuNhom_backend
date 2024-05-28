package com.quanlychiteunhom.backend.test.controller.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quanlychiteunhom.backend.test.controller.entities.Quy;
import com.quanlychiteunhom.backend.test.controller.entities.ThanhVien;
import com.quanlychiteunhom.backend.test.controller.repositories.QuyRepo; // Add this import statement
import com.quanlychiteunhom.backend.test.controller.repositories.ThanhVienRepo; // Add this import statement
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
