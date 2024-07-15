package com.quanlychiteunhom.backend.services;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.quanlychiteunhom.backend.dto.ThuRequest;
import com.quanlychiteunhom.backend.entities.Nhom;
import com.quanlychiteunhom.backend.entities.Quy;
import com.quanlychiteunhom.backend.entities.Thu;
import com.quanlychiteunhom.backend.repositories.NhomRepo;
import com.quanlychiteunhom.backend.repositories.QuyRepo;
import com.quanlychiteunhom.backend.repositories.ThuRepo;

@Service
public class ThuService {

    @Autowired
    private NhomRepo nhomRepo;

    @Autowired
    private ThuRepo thuRepo;

    @Autowired
    private QuyRepo quyRepo;

    public ResponseEntity<?> addThu(ThuRequest thuRequest) {
        try {
            Quy quy = quyRepo.findById(thuRequest.getNhomId())
                                .orElseThrow(() -> new RuntimeException("Quy khong ton tai"));
            quy.setSoTienHT(quy.getSoTienHT() + thuRequest.getSoTien());
            quyRepo.save(quy);
            Thu thu = new Thu();
            thu.setSoTien(thuRequest.getSoTien());
            thu.setMoTa(thuRequest.getMoTa());
            thu.setNgayThu(thuRequest.getNgayThu());
            thu.setQuy(quy);
            return new ResponseEntity<>(thuRepo.save(thu), HttpStatus.CREATED);
        } catch (Exception e) {
            Map<String, String> error = Map.of("error", e.getMessage());
            return ResponseEntity.badRequest().body(error);
        }
    }

}
