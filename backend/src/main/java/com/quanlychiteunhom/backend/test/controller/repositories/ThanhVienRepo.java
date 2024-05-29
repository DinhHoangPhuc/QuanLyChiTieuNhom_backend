package com.quanlychiteunhom.backend.test.controller.repositories;

import com.quanlychiteunhom.backend.test.controller.entities.ThanhVien;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ThanhVienRepo extends JpaRepository<ThanhVien, Integer> {
}
