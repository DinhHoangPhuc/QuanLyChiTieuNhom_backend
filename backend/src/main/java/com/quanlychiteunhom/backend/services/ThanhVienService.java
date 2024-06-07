package com.quanlychiteunhom.backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.quanlychiteunhom.backend.entities.ThanhVien;
import com.quanlychiteunhom.backend.repositories.ThanhVienRepo;
@Service
public class ThanhVienService {

    @Autowired
    private ThanhVienRepo thanhVienRepo;

    public ResponseEntity<List<ThanhVien>> getThanhVIen() {
        try {
            List<ThanhVien> thanhVien = thanhVienRepo.findAll();
            return new ResponseEntity<>(thanhVien, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
