package com.quanlychiteunhom.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quanlychiteunhom.backend.entities.Nhom;
import com.quanlychiteunhom.backend.services.NhomService;
import com.quanlychiteunhom.backend.services.QuyServiceChiaDeu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;



@RestController
public class TestController {

    @Autowired
    private NhomService nhomService;

    @Autowired
    private QuyServiceChiaDeu quyService;
    
    @GetMapping("/nhom")
    public ResponseEntity<List<Nhom>> getNhom() {
        return nhomService.getNhom();
    }

}
