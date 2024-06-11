package com.quanlychiteunhom.backend.repositories;

import com.quanlychiteunhom.backend.entities.ThongBao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ThongBaoRepo extends JpaRepository<ThongBao, Integer> {
    List<ThongBao> findAllByNhom_Id(int nhomid);
}