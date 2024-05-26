package com.quanlychiteunhom.backend.test.controller.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quanlychiteunhom.backend.test.controller.entities.Nhom;

public interface NhomRepo extends JpaRepository<Nhom, Integer>{
    
}
