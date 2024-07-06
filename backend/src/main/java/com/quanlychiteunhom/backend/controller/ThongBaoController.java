package com.quanlychiteunhom.backend.controller;

import com.quanlychiteunhom.backend.dto.ThongBaoRequest;
import com.quanlychiteunhom.backend.services.ThongBaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/thongbao")
public class ThongBaoController {

    @Autowired
    private ThongBaoService thongBaoService;

    @GetMapping("/getThongBao")
    public ResponseEntity<?> getThongBao(@RequestParam int nhomId) {
        return thongBaoService.getThongBao(nhomId);
    }

    @PostMapping("/addThongBao")
    public ResponseEntity<?> addThongBao(@RequestBody ThongBaoRequest thongBaoRequest) {
        return thongBaoService.addThongBao(thongBaoRequest);
    }
}