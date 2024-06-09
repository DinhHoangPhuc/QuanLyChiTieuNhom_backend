package com.quanlychiteunhom.backend.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quanlychiteunhom.backend.entities.NguoiDung;

@Repository
public interface NguoiDungRepo extends JpaRepository<NguoiDung, Integer>{

    Optional<NguoiDung> findByUsername(String username);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

}
