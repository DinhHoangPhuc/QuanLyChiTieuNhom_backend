package com.quanlychiteunhom.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quanlychiteunhom.backend.dto.NhomRequest;
import com.quanlychiteunhom.backend.services.NhomService;

@RestController
@RequestMapping("/api/nhom")
public class NhomController {

    @Autowired    
    private NhomService nhomService;

    @PostMapping("/taoNhom")
    public ResponseEntity<?> addNhom(@RequestBody NhomRequest nhom) {
        return nhomService.addNhom(nhom);
    }
}
