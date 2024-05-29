package com.quanlychiteunhom.backend.test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quanlychiteunhom.backend.test.controller.services.QuyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;



@RestController
public class ChiaTienController {


    @Autowired
    private QuyService quyService;


    @GetMapping("/chiaDeuTien")
    public ResponseEntity<String> chiaDeuTien(@RequestParam("nhomId") int nhomId) {
        try {
            double soTienMoiThanhVien = quyService.chiaDeuTien(nhomId);
            return ResponseEntity.ok("Số tiền mỗi thành viên là: " + soTienMoiThanhVien);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
