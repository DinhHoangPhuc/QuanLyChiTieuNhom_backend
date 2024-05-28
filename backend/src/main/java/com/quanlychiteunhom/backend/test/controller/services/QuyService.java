package com.quanlychiteunhom.backend.test.controller.services;

import com.quanlychiteunhom.backend.test.controller.entities.Quy;
import com.quanlychiteunhom.backend.test.controller.repositories.QuyRepo;
import com.quanlychiteunhom.backend.test.controller.request.QuyRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuyService {

    @Autowired
    private QuyRepo quyRepo;

    public ResponseEntity<List<Quy>> getQuy() {
        try {
            List<Quy> quy = quyRepo.findAll();
            return new ResponseEntity<>(quy, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Quy> addQuy(QuyRequest quyRequest) {
        try {
            Quy quy = new Quy();
            quy.setSoTienBanDau(quyRequest.getSoTienBanDau());
            quy.setSoTienHienTai(quyRequest.getSoTienHienTai());
            quyRepo.save(quy);
            return new ResponseEntity<>(quy, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<List<Quy>> deleteQuy(int quyRequest){
        try {
            List<Quy> quy = quyRepo.findAll();
            quyRepo.deleteById(quy.get(0).getId());
            return new ResponseEntity<>(quy, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
