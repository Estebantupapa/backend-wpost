package com.backend_wpost.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class AuthRequest {
    @NotBlank(message = "Email obligatorio")
    @Email(message = "Email debe ser válido")
    private String email;

    @NotBlank(message = "La contraseña es obligatoria")
    private String password;

    // Getters y Setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}