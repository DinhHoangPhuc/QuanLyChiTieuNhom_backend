package com.quanlychiteunhom.backend.test.controller;

import com.quanlychiteunhom.backend.test.controller.request.ThuRequest;
import org.springframework.web.bind.annotation.*;

import com.quanlychiteunhom.backend.test.controller.entities.Thu;
import com.quanlychiteunhom.backend.test.controller.services.ThuService;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

@RestController

public class ThuController {
    @Autowired
    private ThuService thuService;

    @GetMapping("/thu")
    public ResponseEntity<List<Thu>> getAllThu() {
        return thuService.getThu();
    }

    @PostMapping("/thu")
    public ResponseEntity<Thu> createThu(@RequestBody ThuRequest thu) {
        return thuService.addThu(thu);
    }

    @DeleteMapping("/thu/{id}")
    public ResponseEntity<Void> deleteThu(@PathVariable Long id) {
        return thuService.deleteById(id);
    }
}
