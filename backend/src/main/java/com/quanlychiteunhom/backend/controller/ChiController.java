package com.quanlychiteunhom.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quanlychiteunhom.backend.dto.ChiRequest;
import com.quanlychiteunhom.backend.services.ChiService;

@RestController
@RequestMapping("api/chi")
public class ChiController {

    @Autowired
    private ChiService chiService;

    @PostMapping("/them")
    public ResponseEntity<?> themChi(@RequestBody ChiRequest chiRequest) {
        return chiService.addChi(chiRequest);
    }
}
