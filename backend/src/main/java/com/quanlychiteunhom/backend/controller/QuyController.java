package com.quanlychiteunhom.backend.controller;

import com.quanlychiteunhom.backend.services.QuyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/quy")
public class QuyController {

    @Autowired
    private QuyService quyService;

    @GetMapping("/chia-deu/{nhomId}")
    public ResponseEntity<Double> tinhTienChiaDeu(@PathVariable int nhomId) {
        double soTienChiaDeu = quyService.tinhTienChiaDeu(nhomId);
        return ResponseEntity.ok(soTienChiaDeu);
    }
    @GetMapping("/tvm-dong/{nhomId}")
    public ResponseEntity<Double> tinhTienTVMdong(@PathVariable int nhomId) {
        double soTienTVMdong = quyService.tinhTienChiaDeu(nhomId);
        return ResponseEntity.ok(soTienTVMdong);
    }
    @GetMapping("/hoan-tien/{nhomId}")
    public ResponseEntity<Double> tinhTienHoanLai(@PathVariable int nhomId) {
        double soTienHoanLai = quyService.tinhTienChiaDeu(nhomId);
        return ResponseEntity.ok(soTienHoanLai);
    }

    @GetMapping("/so-tien-hien-tai/{nhomId}")
    public ResponseEntity<Double> soTienHIenTai(@PathVariable int nhomId) {
        double soTien = quyService.soTienHienTai(nhomId);
        return ResponseEntity.ok(soTien);
    }
}
