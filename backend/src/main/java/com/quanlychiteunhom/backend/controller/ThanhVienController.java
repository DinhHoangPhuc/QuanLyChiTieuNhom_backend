package com.quanlychiteunhom.backend.controller;

import com.quanlychiteunhom.backend.request.ThanhVienRequest;
import com.quanlychiteunhom.backend.services.ThanhVienService;
import com.quanlychiteunhom.backend.entities.ThanhVien;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

@RestController
public class ThanhVienController {

    @Autowired
    private ThanhVienService  thanhVienService;

    @GetMapping("/thanhvien")
    public ResponseEntity<List<ThanhVien>> getThanhVien() {
        return thanhVienService.getThanhVIen();
    }

    @PostMapping("/addthanhvien")
    public ResponseEntity<ThanhVien> addThanhVien(@RequestBody ThanhVienRequest thanhVienRequest) {
        return thanhVienService.addThanhVien(thanhVienRequest);
    }
    @DeleteMapping("/deletethanhvien/{id}")
    public ResponseEntity<String> deleteThanhVien(@PathVariable("id") int id) {
        try {
            thanhVienService.deleteThanhVien(id);
            return ResponseEntity.ok("Deleted member successfully");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }
}
