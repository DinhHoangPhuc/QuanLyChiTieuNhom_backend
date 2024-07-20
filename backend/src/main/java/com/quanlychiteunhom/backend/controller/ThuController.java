package com.quanlychiteunhom.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quanlychiteunhom.backend.dto.ThuRequest;
import com.quanlychiteunhom.backend.services.ThuService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/thu")
public class ThuController {

    @Autowired
    private ThuService thuService;

    @PostMapping("/taoThu")
    public ResponseEntity<?> taoThu(@RequestBody ThuRequest thuRequest) {
        return thuService.addThu(thuRequest);
    }

    @GetMapping("/thongKeThuTuan")
    public ResponseEntity<?> thongKeThuTuan(@RequestParam int nhomId) {
        return thuService.thongKeThuTuan(nhomId);
    }
    
    @GetMapping("/thongKeThu/ThuTuanTrongThang")
    public ResponseEntity<?> thongKeThuTuanTrongThang(@RequestParam int nhomId) {
        return thuService.thongKeThuTuanTrongThang(nhomId);
    }
}
