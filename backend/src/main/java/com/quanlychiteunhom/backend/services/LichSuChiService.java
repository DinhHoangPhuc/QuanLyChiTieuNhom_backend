package com.quanlychiteunhom.backend.services;

import com.quanlychiteunhom.backend.entities.LichSuChi;
import com.quanlychiteunhom.backend.repositories.LichSuChiRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LichSuChiService {

    @Autowired
    private LichSuChiRepo lichSuChiRepo;

    public List<LichSuChi> getAllLichSuChi() {
        return lichSuChiRepo.findAll();
    }

    public LichSuChi getLichSuChiById(Long id) {
        return lichSuChiRepo.findById(id).orElse(null);
    }

    public LichSuChi createLichSuChi(LichSuChi lichSuChi) {
        return lichSuChiRepo.save(lichSuChi);
    }

    public void deleteLichSuChi(Long id) {
        lichSuChiRepo.deleteById(id);
    }
}
