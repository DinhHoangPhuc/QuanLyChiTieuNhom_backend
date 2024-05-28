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

    @GetMapping("/test")
    public String test() {
        return "Hello World";
    }
}
