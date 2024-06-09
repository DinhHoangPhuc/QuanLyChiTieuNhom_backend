package com.quanlychiteunhom.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    private String hoTen;
    private String email;
    private int sdt;
    private String username;
    private String password;
    private String avatar;

}
