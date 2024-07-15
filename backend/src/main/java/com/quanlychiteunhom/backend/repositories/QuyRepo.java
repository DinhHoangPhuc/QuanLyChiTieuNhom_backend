package com.quanlychiteunhom.backend.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.quanlychiteunhom.backend.entities.Quy;

public interface QuyRepo extends JpaRepository<Quy, Integer>{

    @Query("SELECT q FROM Quy q WHERE q.nhom.id = ?1")
    Optional<Quy> findByNhomId(@Param("nhomId") int nhomId);
}
