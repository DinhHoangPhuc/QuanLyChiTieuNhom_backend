package com.quanlychiteunhom.backend.services;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.quanlychiteunhom.backend.entities.RefreshToken;
import com.quanlychiteunhom.backend.repositories.NguoiDungRepo;
import com.quanlychiteunhom.backend.repositories.RefreshTokenRepo;

@Service
public class RefreshTokenService {

    @Value("${spring.app.jwtRefreshExpirationMs}")
    private String refreshTokenExpiryTime;

    @Autowired
    private RefreshTokenRepo refreshTokenRepo;

    @Autowired
    private NguoiDungRepo nguoiDungRepo;

    public RefreshToken createRefreshToken(String username) {
        RefreshToken refreshToken = new RefreshToken();
        refreshToken.setNguoiDung(nguoiDungRepo.findByUsername(username).get());
        refreshToken.setToken(UUID.randomUUID().toString());
        refreshToken.setExpiryDate(new Date(System.currentTimeMillis() + Long.parseLong(refreshTokenExpiryTime)));
        refreshTokenRepo.save(refreshToken);
        return refreshToken;
    }

    public RefreshToken verifyExpiration(RefreshToken token) {
        if (token.getExpiryDate().compareTo(new Date()) < 0) {
            refreshTokenRepo.delete(token);
            throw new RuntimeException("Refresh token was expired. Please make a new signin request");
        }
        return token;
    }

    public Optional<RefreshToken> findByToken(String token) {
        return refreshTokenRepo.findByToken(token);
    }

}
