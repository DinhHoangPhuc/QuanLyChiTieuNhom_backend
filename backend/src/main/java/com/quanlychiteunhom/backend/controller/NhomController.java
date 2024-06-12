package com.quanlychiteunhom.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/getAllNhom")
    public ResponseEntity<?> getAllNhom(@RequestParam String username) {
        return nhomService.getNhom(username);
    }

    @DeleteMapping("/xoaNhom")
    public ResponseEntity<?> deleteNhom(@RequestParam int nhomId) {
        return nhomService.deleteNhom(nhomId);
    }
}
