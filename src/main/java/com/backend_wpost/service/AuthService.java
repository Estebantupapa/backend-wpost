package com.backend_wpost.service;

import com.backend_wpost.dto.AuthRequest;
import com.backend_wpost.dto.AuthResponse;

public interface AuthService {
    AuthResponse register(AuthRequest request);
    AuthResponse authenticate(AuthRequest request);
}