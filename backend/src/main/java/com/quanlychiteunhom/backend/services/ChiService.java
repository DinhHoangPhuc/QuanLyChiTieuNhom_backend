package com.quanlychiteunhom.backend.services;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.quanlychiteunhom.backend.dto.ChiRequest;
import com.quanlychiteunhom.backend.entities.Chi;
import com.quanlychiteunhom.backend.entities.Quy;
import com.quanlychiteunhom.backend.repositories.ChiRepo;
import com.quanlychiteunhom.backend.repositories.QuyRepo;

@Service
public class ChiService {

    @Autowired
    private ChiRepo chiRepo;

    @Autowired
    private QuyRepo quyRepo;

    public ResponseEntity<?> addChi(ChiRequest chiRequest) {
        try {
            Quy quy = quyRepo.findById(chiRequest.getNhomId()).get();
            if(chiRequest.getSoTien() > quy.getSoTienHT()){
                throw new RuntimeException("Số tiền chi vượt quá số tiền hiện tại trong quỹ");
            }
            quy.setSoTienHT(quy.getSoTienHT() - chiRequest.getSoTien());
            quyRepo.save(quy);

            Chi chi = new Chi();
            chi.setSoTien(chiRequest.getSoTien());
            chi.setNgayChi(chiRequest.getNgayChi());
            chi.setMoTa(chiRequest.getMoTa());

            quyRepo.findById(chiRequest.getNhomId()).ifPresentOrElse(q -> {
                chi.setQuy(quy);
                chiRepo.save(chi);
            }, () -> {
                throw new RuntimeException("Không tìm thấy nhóm chi");
            });

            return new ResponseEntity<>(chi, org.springframework.http.HttpStatus.CREATED);
        } catch (Exception e) {
            Map<String, String> response = Map.of("error", e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }
}
