package com.quanlychiteunhom.backend.test.controller.services;

import com.quanlychiteunhom.backend.test.controller.entities.ThanhVien;
import com.quanlychiteunhom.backend.test.controller.repositories.ThanhVienRepo;
import com.quanlychiteunhom.backend.test.controller.request.ThanhVienRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // This annotation makes the class a Spring bean
public class ThanhVienService {

    @Autowired
    private ThanhVienRepo thanhVienRepo;

    public ResponseEntity<List<ThanhVien>> getThanhVien() {
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
            _thanhVien.setIdnhom(thanhVienRequest.getIdnhom());
            _thanhVien.setIdnguoidung(thanhVienRequest.getIdnguoidung());
            _thanhVien.setQuyen(thanhVienRequest.getQuyen());
            thanhVienRepo.save(_thanhVien);
            return new ResponseEntity<>(_thanhVien, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
//    public ResponseEntity<Void> deleteThanhVien(int idnhom, int idnguoidung) {
//        try {
//            ThanhVien thanhVien = thanhVienRepo.findById(new ThanhVien.ThanhVienId(idnhom, idnguoidung));
//            if (thanhVien!= null) {
//                thanhVienRepo.delete(thanhVien);
//                return ResponseEntity.noContent().build();
//            } else {
//                return ResponseEntity.notFound().build();
//            }
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//        }
//    }
}