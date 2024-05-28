package com.quanlychiteunhom.backend.test.controller;

import org.springframework.web.bind.annotation.RestController;

import com.quanlychiteunhom.backend.test.controller.entities.Nhom;
import com.quanlychiteunhom.backend.test.controller.request.NhomRequest;
import com.quanlychiteunhom.backend.test.controller.services.NhomService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class TestController {

    @Autowired
    private NhomService nhomService;

    @GetMapping("/test")
    public String test() {
        return "Hello World";
    }

    @GetMapping("/nhom")
    public ResponseEntity<List<Nhom>> getNhom() {
        return nhomService.getNhom();
    }


    @PostMapping("/nhoms")
    public ResponseEntity<Nhom> addNhom(@RequestBody NhomRequest nhom) {
        return nhomService.addNhom(nhom);
    }

}
