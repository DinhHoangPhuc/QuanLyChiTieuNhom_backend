package com.quanlychiteunhom.backend.services;

import com.quanlychiteunhom.backend.entities.LichSuChi;
import com.quanlychiteunhom.backend.entities.LichSuThu;
import com.quanlychiteunhom.backend.repositories.LichSuThuRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LichSuThuService {

    @Autowired
    private LichSuThuRepo lichSuThuRepo;

    public List<LichSuThu> getAllLichSuThu()
    {
        return lichSuThuRepo.findAll();
    }
    public LichSuThu getLichSuThuById(Long id)
    {
        return lichSuThuRepo.findById(id).orElse(null);
    }
    public LichSuThu createLichSuThu (LichSuThu lichSuThu)
    {
        return lichSuThuRepo.save(lichSuThu);
    }

    public void deleteLichSuThu(Long id)
    {
        lichSuThuRepo.deleteById(id);
    }
}
