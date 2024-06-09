package com.quanlychiteunhom.backend.controller;

import com.quanlychiteunhom.backend.entities.LichSuChi;
import com.quanlychiteunhom.backend.services.LichSuChiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LichSuChiController {
    @Autowired
    private LichSuChiService lichSuChiService;


//    @GetMapping
//    public List<LichSuChi> getAllLichSuChi()
//    {
//        return lichSuChiService.getAllLichSuChi();
//    }
//
//    @GetMapping ("/{id}")
//    public LichSuChi getLichSuChiById(@PathVariable Long id)
//    {
//        return lichSuChiService.getLichSuChiById(id);
//    }
//
//    @PostMapping
//    public  LichSuChi createLichSuChi(@RequestBody LichSuChi lichSuChi)
//    {
//        return lichSuChiService.createLichSuChi(lichSuChi);
//    }
    @PostMapping ("/chi")
    public ResponseEntity<Void> createChi(@RequestBody LichSuChi chi) {
        // Lưu chi vào database
        return ResponseEntity.ok().build();
    }
//    @DeleteMapping("/{id}")
//    public void deleteLichSuChi(@PathVariable Long id)
//    {
//        lichSuChiService.deleteLichSuChi(id);
//    }
}
