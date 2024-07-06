package com.quanlychiteunhom.backend.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quanlychiteunhom.backend.entities.RefreshToken;

public interface RefreshTokenRepo extends JpaRepository<RefreshToken, Integer>{
    public Optional<RefreshToken> findByToken(String token);
}
