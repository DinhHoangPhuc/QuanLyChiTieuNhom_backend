package com.quanlychiteunhom.backend.test.controller;

import com.quanlychiteunhom.backend.test.controller.entities.Quy;
import com.quanlychiteunhom.backend.test.controller.request.QuyRequest;
import com.quanlychiteunhom.backend.test.controller.services.QuyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class QuyController {
    @Autowired
    private QuyService quyService;

    @GetMapping("/quy")
    public ResponseEntity<List<Quy>> getQuy() {
        return quyService.getQuy();
    }

    @PostMapping("/quy")
    public ResponseEntity<Quy> addQuy(@RequestBody QuyRequest quy) {
        return quyService.addQuy(quy);
    }

    @DeleteMapping("/quy/{id}")
    public ResponseEntity<List<Quy>> deleteQuy(@PathVariable int id) {
        return quyService.deleteQuy(id);
    }
}
