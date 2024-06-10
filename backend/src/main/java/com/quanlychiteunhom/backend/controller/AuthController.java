package com.quanlychiteunhom.backend.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quanlychiteunhom.backend.dto.JwtResponse;
import com.quanlychiteunhom.backend.dto.LoginRequest;
import com.quanlychiteunhom.backend.dto.LoginResponse;
import com.quanlychiteunhom.backend.dto.RegisterRequest;
import com.quanlychiteunhom.backend.dto.RegisterResponse;
import com.quanlychiteunhom.backend.entities.NguoiDung;
import com.quanlychiteunhom.backend.security.services.UserDetailService;
import com.quanlychiteunhom.backend.security.util.JwtUtil;
import com.quanlychiteunhom.backend.services.AuthService;

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
    private UserDetailService userDetailsService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest registerRequest) {
        try {
            authService.register(registerRequest);
            RegisterResponse registerResponse = new RegisterResponse("Đăng ký thành công");
            return ResponseEntity.ok(registerResponse);
        } catch (RuntimeException e) {
            Map<String, String> error = Map.of("error", e.getMessage());
            return ResponseEntity.badRequest().body(error);
        }
    }

    // @PostMapping("/login")
    // public ResponseEntity<?> login(@RequestBody LoginRequest nguoiDung) {
    //     try {
    //         Authentication authentication = authenticationManager.authenticate(
    //             new UsernamePasswordAuthenticationToken(
    //                 nguoiDung.getUsername(), nguoiDung.getPassword()));

    //         SecurityContextHolder.getContext().setAuthentication(authentication);
            
    //         return ResponseEntity.ok("Đăng nhập thành công");
    //     } catch (RuntimeException e) {
    //         return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Đăng nhập thất bại");
    //     }
    // }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest nguoiDung) {
        Authentication authentication;
        try {
            authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                    nguoiDung.getUsername(), nguoiDung.getPassword()));
        } catch (AuthenticationException e) {
            Map<String, String> error = Map.of("error", "Đăng nhập thất bại");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
        }

        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        String jwt = jwtUtil.generateTokenFromUsername(userDetails);

        LoginResponse loginResponse = new LoginResponse(jwt, userDetails.getUsername());

        return ResponseEntity.ok(loginResponse);
    }
}
