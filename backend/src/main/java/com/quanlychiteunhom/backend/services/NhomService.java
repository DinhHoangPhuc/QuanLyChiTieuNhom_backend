package com.quanlychiteunhom.backend.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.quanlychiteunhom.backend.dto.NhomRequest;
import com.quanlychiteunhom.backend.entities.NguoiDung;
import com.quanlychiteunhom.backend.entities.Nhom;
import com.quanlychiteunhom.backend.entities.ThanhVien;
import com.quanlychiteunhom.backend.repositories.NguoiDungRepo;
import com.quanlychiteunhom.backend.repositories.NhomRepo;
import com.quanlychiteunhom.backend.repositories.ThanhVienRepo;

@Service
public class NhomService {

    @Autowired
    private NhomRepo nhomRepo;

    @Autowired
    private NguoiDungRepo nguoiDungRepo;

    @Autowired
    private ThanhVienRepo thanhVienRepo;

    public ResponseEntity<?> getNhom(String username) {
        try {
            NguoiDung nguoiDung = nguoiDungRepo.findByUsername(username).orElseThrow(() -> new RuntimeException("Người dùng không tồn tại"));
            int id = nguoiDung.getId();
            List<Nhom> nhom = thanhVienRepo.findByNguoiDung(id);
            return new ResponseEntity<>(nhom, HttpStatus.OK);
        } catch (Exception e) {
            Map<String, String> response = Map.of("error", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<?> addNhom(NhomRequest nhom) {
        try {
            Nhom _nhom = new Nhom();
            _nhom.setTenNhom(nhom.getTenNhom());
            _nhom.setMoTa(nhom.getMoTa());
            _nhom.setHinhNhom(nhom.getHinhNhom());
            nhomRepo.save(_nhom);
            NguoiDung nguoiDung = nguoiDungRepo.findByUsername(nhom.getUsername()).orElseThrow(() -> new RuntimeException("Người dùng không tồn tại"));
            ThanhVien thanhVien = new ThanhVien();
            thanhVien.setNguoiDung(nguoiDung);
            thanhVien.setNhom(_nhom);
            thanhVien.setQuyen(1);
            thanhVienRepo.save(thanhVien);
            return new ResponseEntity<>(_nhom, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    public ResponseEntity<?> deleteNhom(int id) {
        try {
            Nhom nhom = nhomRepo.findById(id).orElseThrow(() -> new RuntimeException("Nhóm không tồn tại"));
            nhomRepo.delete(nhom);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    
}
