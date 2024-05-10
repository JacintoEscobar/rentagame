package com.jasi.rentagame.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginRequestBody {
    @NotBlank(message = "username is required")
    @Size(min = 8, max = 45, message = "username length must be about 8 characters as minimum or 45 characters as maximum")
    private String username;

    @NotBlank(message = "password is required")
    @Size(min = 8, max = 45, message = "password length must be about 8 characters as minimum or 45 characters as maximum")
    private String password;
}
