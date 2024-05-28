package com.quanlychiteunhom.backend.test.controller;

import com.quanlychiteunhom.backend.test.controller.entities.Quy;
import com.quanlychiteunhom.backend.test.controller.repositories.NhomRepo;
import com.quanlychiteunhom.backend.test.controller.request.QuyRequest;
import com.quanlychiteunhom.backend.test.controller.services.QuyService;
import org.springframework.web.bind.annotation.*;

import com.quanlychiteunhom.backend.test.controller.entities.Nhom;
import com.quanlychiteunhom.backend.test.controller.request.NhomRequest;
import com.quanlychiteunhom.backend.test.controller.services.NhomService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;


@RestController
public class TestController {

    @Autowired
    private NhomService nhomService;
    private QuyService quyService;

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

    @DeleteMapping("/nhom/delete/{id}")
    public ResponseEntity<List<Nhom>> deleteNhom(@PathVariable int id) {
        return nhomService.deleteNhom(id);
    }

    @GetMapping("/quy")
    public ResponseEntity<List<Quy>> getQuy() {
        return quyService.getQuy();
    }

    @PostMapping("/quys")
    public ResponseEntity<Quy> addQuy(@RequestBody QuyRequest quy) {
        return quyService.addQuy(quy);
    }

    @DeleteMapping("/quy/delete/{id}")
    public ResponseEntity<List<Quy>> deleteQuy(@PathVariable int id) {
        return quyService.deleteQuy(id);
    }
}
