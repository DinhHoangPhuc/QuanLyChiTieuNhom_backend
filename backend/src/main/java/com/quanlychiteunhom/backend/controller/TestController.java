package com.quanlychiteunhom.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quanlychiteunhom.backend.entities.Nhom;
import com.quanlychiteunhom.backend.services.NhomService;
import com.quanlychiteunhom.backend.services.QuyService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;



@RestController
public class TestController {

    @Autowired
    private NhomService nhomService;

    @Autowired
    private QuyService quyService;

    // @GetMapping("/nhom")
    // public ResponseEntity<List<Nhom>> getNhom() {
    //     return nhomService.getNhom();
    // }


    // @Autowired
    // public ResponseEntity<Quy> getTIenHT(QuyRequest quyRequest) {
    //     Quy quy = new Quy();
    //     quy.getSoTienHT();
    //     return ResponseEntity.ok(quy);
    // }
    
    // @GetMapping("/nhom")
    // public ResponseEntity<List<Nhom>> getNhom() {
    //     return nhomService.getNhom();
    // }

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
