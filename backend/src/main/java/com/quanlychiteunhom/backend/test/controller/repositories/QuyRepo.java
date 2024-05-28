package com.quanlychiteunhom.backend.test.controller.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quanlychiteunhom.backend.test.controller.entities.Quy;

public interface QuyRepo extends JpaRepository<Quy, Integer>{
    
}
