package com.quanlychiteunhom.backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.quanlychiteunhom.backend.dto.NhomRequest;
import com.quanlychiteunhom.backend.entities.Nhom;
import com.quanlychiteunhom.backend.repositories.NhomRepo;

@Service
public class NhomService {

    @Autowired
    private NhomRepo nhomRepo;

    public ResponseEntity<List<Nhom>> getNhom() {
        try {
            List<Nhom> nhom = nhomRepo.findAll();
            return new ResponseEntity<>(nhom, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<?> addNhom(NhomRequest nhom) {
        try {
            Nhom _nhom = new Nhom();
            _nhom.setTenNhom(nhom.getTenNhom());
            _nhom.setMoTa(nhom.getMoTa());
            _nhom.setHinhNhom(nhom.getHinhNhom());
            nhomRepo.save(_nhom);
            return new ResponseEntity<>(_nhom, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
