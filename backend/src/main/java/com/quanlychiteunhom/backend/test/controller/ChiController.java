package com.quanlychiteunhom.backend.test.controller;

import com.quanlychiteunhom.backend.test.controller.request.ChiRequest;

import org.springframework.web.bind.annotation.*;

import com.quanlychiteunhom.backend.test.controller.entities.Chi;
import com.quanlychiteunhom.backend.test.controller.services.ChiService;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

@RestController
public class ChiController {

    @Autowired
    private ChiService chiService;


    @GetMapping("/chi")
    public ResponseEntity<List<Chi>> getAllChi() {
        return chiService.getChi();
    }

    @PostMapping("/chi")
    public ResponseEntity<Chi> createChi(@RequestBody ChiRequest chi) {
        return chiService.addChi(chi);
    }

    @DeleteMapping("/chi/{id}")
    public ResponseEntity<Void> deleteChi(@PathVariable Long id) {
        return chiService.deleteByID(id);
    }
}
