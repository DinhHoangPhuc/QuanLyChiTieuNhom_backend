package com.quanlychiteunhom.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.quanlychiteunhom.backend.dto.RegisterRequest;
import com.quanlychiteunhom.backend.entities.NguoiDung;
import com.quanlychiteunhom.backend.repositories.NguoiDungRepo;

@Service
public class AuthService {

    @Autowired
    private NguoiDungRepo nguoiDungRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public NguoiDung register(RegisterRequest registerRequest) {
        if(nguoiDungRepo.existsByEmail(registerRequest.getEmail()) ||nguoiDungRepo.existsByUsername(registerRequest.getUsername())) {
            throw new RuntimeException("Email hoặc username đã tồn tại");
        }
        NguoiDung nguoiDung = new NguoiDung();
        nguoiDung.setHoTen(registerRequest.getHoTen());
        nguoiDung.setEmail(registerRequest.getEmail());
        nguoiDung.setSdt(registerRequest.getSdt());
        nguoiDung.setUsername(registerRequest.getUsername());
        nguoiDung.setPassword(passwordEncoder.encode(registerRequest.getPassword()));

        return nguoiDungRepo.save(nguoiDung);
    }

}
