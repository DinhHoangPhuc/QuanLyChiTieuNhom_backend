package com.quanlychiteunhom.backend.test.controller.repositories;

import com.quanlychiteunhom.backend.test.controller.entities.Quy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuyRepo extends JpaRepository<Quy, Integer> {
}
