package com.quanlychiteunhom.backend.test.controller;

import com.quanlychiteunhom.backend.test.controller.entities.Nhom;
import com.quanlychiteunhom.backend.test.controller.request.NhomRequest;
import com.quanlychiteunhom.backend.test.controller.services.NhomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NhomController {
    @Autowired
    private NhomService nhomService;

    @GetMapping("/nhom")
    public ResponseEntity<List<Nhom>> getNhom() {
        return nhomService.getNhom();
    }


    @PostMapping("/nhom")
    public ResponseEntity<Nhom> addNhom(@RequestBody NhomRequest nhom) {
        return nhomService.addNhom(nhom);
    }

    @DeleteMapping("/nhom/{id}")
    public ResponseEntity<List<Nhom>> deleteNhom(@PathVariable int id) {
        return nhomService.deleteNhom(id);
    }
}
