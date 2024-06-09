package com.quanlychiteunhom.backend.controller;

import com.quanlychiteunhom.backend.entities.LichSuThu;
import com.quanlychiteunhom.backend.services.LichSuThuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lich_su_thu")
public class LichSuThuController {
    @Autowired
    private LichSuThuService LichSuThuService;

    @GetMapping
    public List<LichSuThu> getAllLichSuThu()
    {
        return LichSuThuService.getAllLichSuThu();
    }

    @GetMapping ("/{id}")
    public LichSuThu getLichSuThuById(@PathVariable Long id)
    {
        return LichSuThuService.getLichSuThuById(id);
    }

    @PostMapping
    public  LichSuThu createLichSuThu(@RequestBody LichSuThu LichSuThu)
    {
        return LichSuThuService.createLichSuThu(LichSuThu);
    }

    @DeleteMapping("/{id}")
    public void deleteLichSuThu(@PathVariable Long id)
    {
        LichSuThuService.deleteLichSuThu(id);
    }
}
