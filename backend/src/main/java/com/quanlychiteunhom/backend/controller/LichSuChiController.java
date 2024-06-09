package com.quanlychiteunhom.backend.controller;

import com.quanlychiteunhom.backend.entities.LichSuChi;
import com.quanlychiteunhom.backend.services.LichSuChiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lich_su_chi")
public class LichSuChiController {
    @Autowired
    private LichSuChiService lichSuChiService;

    @GetMapping
    public List<LichSuChi> getAllLichSuChi()
    {
        return lichSuChiService.getAllLichSuChi();
    }

    @GetMapping ("/{id}")
    public LichSuChi getLichSuChiById(@PathVariable Long id)
    {
        return lichSuChiService.getLichSuChiById(id);
    }

    @PostMapping
    public  LichSuChi createLichSuChi(@RequestBody LichSuChi lichSuChi)
    {
        return lichSuChiService.createLichSuChi(lichSuChi);
    }

    @DeleteMapping("/{id}")
    public void deleteLichSuChi(@PathVariable Long id)
    {
        lichSuChiService.deleteLichSuChi(id);
    }
}
