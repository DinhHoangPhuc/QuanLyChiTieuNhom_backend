package com.quanlychiteunhom.backend.controller;

import com.quanlychiteunhom.backend.services.TinhTienImpl;
import com.quanlychiteunhom.backend.services.TinhTienService;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/quy")
public class TinhTienController {

    @Autowired
    private TinhTienService quyService;

    @GetMapping("/chia-deu/{nhomId}")
    public ResponseEntity<?> tinhTienChiaDeu(@PathVariable int nhomId) {
        Map<String, Double> soTienChiaDeu = quyService.tinhTienChiaDeu(nhomId);
        return ResponseEntity.ok(soTienChiaDeu);
    }
    @GetMapping("/tvm-dong/{nhomId}")
    public ResponseEntity<?> tinhTienTVMdong(@PathVariable int nhomId) {
        Map<String, Double> soTienTVMdong = quyService.tinhTienChiaDeu(nhomId);
        return ResponseEntity.ok(soTienTVMdong);
    }
    @GetMapping("/hoan-tien/{nhomId}")
    public ResponseEntity<?> tinhTienHoanLai(@PathVariable int nhomId) {
        Map<String, Double> soTienHoanLai = quyService.tinhTienChiaDeu(nhomId);
        return ResponseEntity.ok(soTienHoanLai);
    }

    @GetMapping("/so-tien-hien-tai/{nhomId}")
    public ResponseEntity<?> soTienHIenTai(@PathVariable int nhomId) {
        Map<String, Double> soTien = quyService.soTienHienTai(nhomId);
        return ResponseEntity.ok(soTien);
    }
}
