package com.quanlychiteunhom.backend.services;

import java.util.List;

import com.quanlychiteunhom.backend.request.ThanhVienRequest;
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
    public ResponseEntity<ThanhVien> addThanhVien(ThanhVienRequest thanhVienRequest) {
        try {
            ThanhVien _thanhVien = new ThanhVien();
            _thanhVien.setNhomId(thanhVienRequest.getNhomId());
            _thanhVien.setNguoiDungId(thanhVienRequest.getNguoiDungId());
            _thanhVien.setQuyen(thanhVienRequest.getQuyen());
            thanhVienRepo.save(_thanhVien);
            return new ResponseEntity<>(_thanhVien, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    public ResponseEntity<String> deleteThanhVien(int id) {
        try {
            thanhVienRepo.deleteById(id);
            return new ResponseEntity<>("Deleted member successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
