package com.quanlychiteunhom.backend.controller;

import com.quanlychiteunhom.backend.entities.LichSuThu;
import com.quanlychiteunhom.backend.services.LichSuThuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LichSuThuController {
    @Autowired
    private LichSuThuService LichSuThuService;

//    @GetMapping
//    public List<LichSuThu> getAllLichSuThu()
//    {
//        return LichSuThuService.getAllLichSuThu();
//    }
//
//    @GetMapping ("/{id}")
//    public LichSuThu getLichSuThuById(@PathVariable Long id)
//    {
//        return LichSuThuService.getLichSuThuById(id);
//    }
//
//    @PostMapping
//    public  LichSuThu createLichSuThu(@RequestBody LichSuThu LichSuThu)
//    {
//        return LichSuThuService.createLichSuThu(LichSuThu);
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteLichSuThu(@PathVariable Long id)
//    {
//        LichSuThuService.deleteLichSuThu(id);
//    }
    @PostMapping("/thu")
    public ResponseEntity<Void> createThu(@RequestBody LichSuThu thu) {
        // Lưu thu vào database
        return ResponseEntity.ok().build();
    }
}
