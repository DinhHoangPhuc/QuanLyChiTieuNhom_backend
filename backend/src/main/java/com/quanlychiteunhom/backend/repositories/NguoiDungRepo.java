package com.quanlychiteunhom.backend.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.quanlychiteunhom.backend.entities.NguoiDung;

@Repository
public interface NguoiDungRepo extends JpaRepository<NguoiDung, Integer>{

    Optional<NguoiDung> findByUsername(String username);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    // @Query("SELECT CASE WHEN COUNT(n) > 0 THEN true ELSE false END FROM NguoiDung n WHERE n.sdt = ?1")
    boolean existsBySdt(int sdt);
}
