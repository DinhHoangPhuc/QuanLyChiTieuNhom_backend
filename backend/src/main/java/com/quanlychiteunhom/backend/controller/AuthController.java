package com.quanlychiteunhom.backend.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quanlychiteunhom.backend.dto.LoginRequest;
import com.quanlychiteunhom.backend.dto.LoginResponse;
import com.quanlychiteunhom.backend.dto.RefreshTokenRequest;
import com.quanlychiteunhom.backend.dto.RegisterRequest;
import com.quanlychiteunhom.backend.dto.RegisterResponse;
import com.quanlychiteunhom.backend.entities.RefreshToken;
import com.quanlychiteunhom.backend.security.util.JwtUtil;
import com.quanlychiteunhom.backend.services.AuthService;
import com.quanlychiteunhom.backend.services.RefreshTokenService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private RefreshTokenService refreshTokenService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody RegisterRequest registerRequest,
                                                            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, String> error = new HashMap<>();
            bindingResult.getFieldErrors().forEach(fieldError -> {
                error.put(fieldError.getField(), fieldError.getDefaultMessage());
            });
            return ResponseEntity.badRequest().body(error);
        }

        try {
            authService.register(registerRequest);
            RegisterResponse registerResponse = new RegisterResponse("Đăng ký thành công");
            return new ResponseEntity<>(registerResponse, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            Map<String, String> error = Map.of("error", e.getMessage());
            return ResponseEntity.badRequest().body(error);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest nguoiDung) {
        Authentication authentication;
        try {
            authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                    nguoiDung.getUsername(),
                    nguoiDung.getPassword()));
        } catch (AuthenticationException e) {
            Map<String, String> error = Map.of("error", "Đăng nhập thất bại");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(error);
        }

        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        String jwt = jwtUtil.generateTokenFromUsername(userDetails.getUsername());
        String refreshToken = refreshTokenService.createRefreshToken(userDetails.getUsername()).getToken();

        LoginResponse loginResponse = new LoginResponse(jwt, userDetails.getUsername(), refreshToken);

        return ResponseEntity.ok(loginResponse);
    }

    @PostMapping("/refreshToken")
    public ResponseEntity<?> refreshToken (@RequestBody RefreshTokenRequest refreshTokenRequest) {
        try {
            String requestToken = refreshTokenRequest.getRefreshToken();
        return refreshTokenService.findByToken(requestToken)
                .map(refreshTokenService::verifyExpiration)
                .map(RefreshToken::getNguoiDung)
                .map(user -> {
                    String jwt = jwtUtil.generateTokenFromUsername(user.getUsername());
                    return new ResponseEntity<>(new LoginResponse(jwt, user.getUsername(), requestToken), HttpStatus.CREATED);
                })
                .orElseThrow(() -> new RuntimeException("Refresh token was expired. Please make a new signin request"));
        } catch (RuntimeException e) {
            Map<String, String> error = Map.of("error", e.getMessage());
            return ResponseEntity.badRequest().body(error);
        }
    }
}
