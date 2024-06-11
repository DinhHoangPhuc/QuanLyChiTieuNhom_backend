package com.quanlychiteunhom.backend.services;

import com.quanlychiteunhom.backend.dto.ThongBaoRequest;
import com.quanlychiteunhom.backend.entities.*;
import com.quanlychiteunhom.backend.repositories.NhomRepo;
import com.quanlychiteunhom.backend.repositories.ThongBaoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ThongBaoService {

    @Autowired
    private ThongBaoRepo thongBaoRepo;

    @Autowired
    private NhomRepo nhomRepo;

    public ResponseEntity<?> getThongBao(int nhomId) {
    try {
        List<ThongBao> thongBao = thongBaoRepo.findAllByNhom_Id(nhomId);
        return new ResponseEntity<>(thongBao, HttpStatus.OK);
    } catch (Exception e) {
        Map<String, String> response = Map.of("error", e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}

    public ResponseEntity<?> addThongBao(ThongBaoRequest thongBaoRequest) {
        try {
            Nhom nhom = nhomRepo.findById(thongBaoRequest.getNhomid()).orElseThrow(() -> new RuntimeException("Nhom khong ton tai"));
            ThongBao thongBao = new ThongBao();
            thongBao.setTieude(thongBaoRequest.getTieude());
            thongBao.setNoiDung(thongBaoRequest.getNoiDung());
            thongBao.setNgaydang(thongBaoRequest.getNgaydang());
            nhom.getThongBao().add(thongBao);
            thongBao.setNhom(nhom);
            thongBaoRepo.save(thongBao);
            return new ResponseEntity<>(thongBaoRepo.save(thongBao), HttpStatus.CREATED);
        } catch (Exception e) {
            Map<String, String> error = Map.of("error", e.getMessage());
            return ResponseEntity.badRequest().body(error);
        }
    }
}