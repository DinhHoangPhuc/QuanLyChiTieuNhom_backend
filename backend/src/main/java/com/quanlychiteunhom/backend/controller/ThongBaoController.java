package com.quanlychiteunhom.backend.controller;


import com.quanlychiteunhom.backend.entities.ThongBao;
import com.quanlychiteunhom.backend.request.ThongBaoRequest;
import com.quanlychiteunhom.backend.services.ThongBaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ThongBaoController {

    @Autowired
    private ThongBaoService thongBaoService;

    @GetMapping("/thongbao")
    public ResponseEntity<List<ThongBao>> getThongBao() {
        return thongBaoService.getThongBao();
    }

    @PostMapping("/addthongbao")
    public ResponseEntity<ThongBao> addThongBao(@RequestBody ThongBaoRequest thongBaoRequest) {
        return thongBaoService.addThongBao(thongBaoRequest);
    }
    // Other controller methods...
}