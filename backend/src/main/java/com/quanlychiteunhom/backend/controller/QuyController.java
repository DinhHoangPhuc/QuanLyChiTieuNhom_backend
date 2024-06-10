package com.quanlychiteunhom.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quanlychiteunhom.backend.dto.QuyRequest;
import com.quanlychiteunhom.backend.services.QuyService;

@RestController
@RequestMapping("/api/quy")
public class QuyController {

    @Autowired
    private QuyService quyService;

    @PostMapping("/taoQuy")
    public ResponseEntity<?> taoQuy(@RequestBody QuyRequest quyRequest) {
        return quyService.addQuy(quyRequest);
    }
}
