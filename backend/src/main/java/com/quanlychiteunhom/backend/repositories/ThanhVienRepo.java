package com.quanlychiteunhom.backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quanlychiteunhom.backend.entities.ThanhVien;

public interface ThanhVienRepo extends JpaRepository<ThanhVien, Integer>{
    List<ThanhVien> findByNhomId(int nhomId);
}
