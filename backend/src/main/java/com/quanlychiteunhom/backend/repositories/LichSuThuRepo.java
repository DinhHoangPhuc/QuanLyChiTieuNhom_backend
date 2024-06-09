package com.quanlychiteunhom.backend.repositories;

import com.quanlychiteunhom.backend.entities.LichSuThu;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.quanlychiteunhom.backend.entities.LichSuThu;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LichSuThuRepo extends JpaRepository<LichSuThu, Long> {

}
