package com.quanlychiteunhom.backend.test.controller.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quanlychiteunhom.backend.test.controller.entities.Chi;

public interface ChiRepo extends JpaRepository<Chi, Long> {
    
}
