package com.quanlychiteunhom.backend.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.quanlychiteunhom.backend.dto.QuyRequest;
import com.quanlychiteunhom.backend.entities.Nhom;
import com.quanlychiteunhom.backend.entities.Quy;
import com.quanlychiteunhom.backend.entities.ThanhVien;
import com.quanlychiteunhom.backend.repositories.NhomRepo;
import com.quanlychiteunhom.backend.repositories.QuyRepo;
import com.quanlychiteunhom.backend.repositories.ThanhVienRepo;

@Service
public class QuyService {
    @Autowired
    private QuyRepo quyRepo;

    @Autowired
    private ThanhVienRepo thanhVienRepo;

    @Autowired
    private NhomRepo nhomRepo;

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

    public ResponseEntity<?> addQuy(QuyRequest quy) {
        try {
            Nhom nhom = nhomRepo.findById(quy.getNhomId()).orElseThrow(() -> new RuntimeException("Nhóm không tồn tại"));
            Quy _quy = new Quy();
            _quy.setNhomId(quy.getNhomId());
            _quy.setSoTienBD(quy.getSoTienBD());
            _quy.setSoTienHT(quy.getSoTienHT());
            quyRepo.save(_quy);
            return new ResponseEntity<>(_quy, HttpStatus.CREATED);
        } catch (Exception e) {
            Map<String, String> error = Map.of("error", e.getMessage());
            return ResponseEntity.badRequest().body(error);
        }
    }

    public ResponseEntity<?> getQuy(int nhomId) {
        try {
            Quy quy = quyRepo.findById(nhomId).orElseThrow(() -> new RuntimeException("Quỹ không tồn tại"));
            return new ResponseEntity<>(quy, HttpStatus.OK);
        } catch (Exception e) {
            Map<String, String> error = Map.of("error", e.getMessage());
            return ResponseEntity.badRequest().body(error);
        }
    }
}
