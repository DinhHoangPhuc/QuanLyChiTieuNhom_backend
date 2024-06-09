package com.quanlychiteunhom.backend.services;

import com.quanlychiteunhom.backend.entities.ThongBao;
import com.quanlychiteunhom.backend.repositories.ThongBaoRepo;
import com.quanlychiteunhom.backend.request.ThongBaoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThongBaoService {

    @Autowired
    private ThongBaoRepo thongBaoRepo;

    public ResponseEntity<List<ThongBao>> getThongBao() {
        try {
            List<ThongBao> thanhVien = thongBaoRepo.findAll();
            return new ResponseEntity<>(thanhVien, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<ThongBao> addThongBao(ThongBaoRequest thongBaoRequest) {
        try {
            ThongBao _thongbao = new ThongBao();
            _thongbao.setTieude(thongBaoRequest.getTieude());
            _thongbao.setNoidung(thongBaoRequest.getNoidung());
            _thongbao.setNgaydang(thongBaoRequest.getNgaydang());
            _thongbao.setIdnhom(thongBaoRequest.getIdnhom());
            thongBaoRepo.save(_thongbao);
            return new ResponseEntity<>(_thongbao, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}