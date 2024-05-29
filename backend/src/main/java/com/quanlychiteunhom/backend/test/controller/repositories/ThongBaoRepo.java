package com.quanlychiteunhom.backend.test.controller.repositories;

import com.quanlychiteunhom.backend.test.controller.entities.ThongBao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ThongBaoRepo extends JpaRepository<ThongBao, Integer> {
}
