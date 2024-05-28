package com.quanlychiteunhom.backend.test.controller;

import com.quanlychiteunhom.backend.test.controller.entities.ThanhVien;
import com.quanlychiteunhom.backend.test.controller.request.ThanhVienRequest;
import com.quanlychiteunhom.backend.test.controller.services.ThanhVienService;
import org.springframework.web.bind.annotation.RestController;

import com.quanlychiteunhom.backend.test.controller.entities.Nhom;
import com.quanlychiteunhom.backend.test.controller.request.NhomRequest;
import com.quanlychiteunhom.backend.test.controller.services.NhomService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class TestController {

    @Autowired
    private NhomService nhomService;

    @Autowired
    private ThanhVienService thanhVienService;

    @GetMapping("/thanhvien")
    public ResponseEntity<List<ThanhVien>> getThanhVien() {
        return thanhVienService.getThanhVien();
    }

    @PostMapping("/thanhviens")
    public ResponseEntity<ThanhVien> addThanhVien(@RequestBody ThanhVienRequest thanhVienRequest) {
        return thanhVienService.addThanhVien(thanhVienRequest);
    }

}
