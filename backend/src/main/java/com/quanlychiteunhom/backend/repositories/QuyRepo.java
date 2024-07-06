package com.quanlychiteunhom.backend.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quanlychiteunhom.backend.entities.Quy;

public interface QuyRepo extends JpaRepository<Quy, Integer>{
    Optional<Quy> findByNhomId(int nhomId);
}
