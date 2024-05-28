package com.quanlychiteunhom.backend.test.controller.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quanlychiteunhom.backend.test.controller.entities.ThanhVien;

public interface ThanhVienRepo extends JpaRepository<ThanhVien, Integer>{
    List<ThanhVien> findByNhomId(int nhomId);
}
