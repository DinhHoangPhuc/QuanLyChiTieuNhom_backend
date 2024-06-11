package com.quanlychiteunhom.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quanlychiteunhom.backend.dto.ChiRequest;
import com.quanlychiteunhom.backend.services.ChiService;

@RestController
@RequestMapping("api/chi")
public class ChiController {

    @Autowired
    private ChiService chiService;

    @PostMapping("/them")
    public ResponseEntity<?> themChi(@RequestBody ChiRequest chiRequest) {
        return chiService.addChi(chiRequest);
    }

    @GetMapping("/thongKeChiTuan")
    public ResponseEntity<?> thongKeChiTuan(@RequestParam int nhomId) {
        return chiService.thongKeChiTuan(nhomId);
    }

    @GetMapping("/thongKeChi/chiTuanTrongThang")
    public ResponseEntity<?> thongKeChiTuanTrongThang(@RequestParam int nhomId) {
        return chiService.thongKeChiTuanTrongThang(nhomId);
    }

    @GetMapping("/test")
    public ResponseEntity<?> test(@RequestParam int nhomId) {
        return ResponseEntity.ok("Test success");
    }
}
