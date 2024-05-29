package com.quanlychiteunhom.backend.test.controller.services;

import java.util.List;

import com.quanlychiteunhom.backend.test.controller.request.ThuRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.quanlychiteunhom.backend.test.controller.entities.Thu;
import com.quanlychiteunhom.backend.test.controller.repositories.ThuRepo;

@Service
public class ThuService {
    @Autowired
    private ThuRepo thuRepo;

    public ResponseEntity<List<Thu>> getThu() {
        try {
            List<Thu> thu = thuRepo.findAll();
            return new ResponseEntity<>(thu, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Thu> addThu(ThuRequest thuRequest) {
        try {
            Thu _thu = new Thu();
            _thu.setId(thuRequest.getId());
            _thu.setSoTien(thuRequest.getSoTien());
            _thu.setNgayThu(thuRequest.getNgayThu());
            _thu.setMoTa(thuRequest.getMoTa());
            _thu.setNhomId(thuRequest.getNhomId());
            Thu savedThu = thuRepo.save(_thu);
            return new ResponseEntity<>(savedThu, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Void> deleteById(Long id) {
        try {
            if (thuRepo.existsById(id)) {
                thuRepo.deleteById(id);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
