package com.quanlychiteunhom.backend.dto;

import org.springframework.format.annotation.NumberFormat;

import com.quanlychiteunhom.backend.custom_annotation.Unique;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    @NotBlank(message = "Họ tên không được để trống")
    private String hoTen;

    @Email(message = "Email không hợp lệ")
    @Unique(fieldType = Unique.FieldType.EMAIL,
            message = "Email đã tồn tại")
    private String email;

    @NumberFormat(style = NumberFormat.Style.NUMBER)
    @Unique(fieldType = Unique.FieldType.SDT,
            message = "Số điện thoại đã tồn tại")
    private int sdt;

    @NotBlank(message = "Tên đăng nhập không được để trống")
    @Unique(fieldType = Unique.FieldType.USERNAME,
            message = "Tên đăng nhập đã tồn tại")
    private String username;

    @Pattern(regexp = ".{6,}",
            message = "Mật khẩu tối thiểu 6 kí tự")
    private String password;

    private String avatar;

}
