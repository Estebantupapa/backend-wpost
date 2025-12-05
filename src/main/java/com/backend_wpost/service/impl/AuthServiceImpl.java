package com.backend_wpost.service.impl;

import com.backend_wpost.config.JwtService;
import com.backend_wpost.dto.AuthRequest;
import com.backend_wpost.dto.AuthResponse;
import com.backend_wpost.entity.user;
import com.backend_wpost.repository.UserRepository;
import com.backend_wpost.service.AuthService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    // Constructor con inyección de dependencias
    public AuthServiceImpl(UserRepository userRepository,
                           PasswordEncoder passwordEncoder,
                           JwtService jwtService,
                           AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    @Override
    public AuthResponse register(AuthRequest request) {
        // Verificar si el email ya existe
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("El email ya está registrado");
        }

        // Crear nuevo usuario
        user User = new user();
        User.setEmail(request.getEmail());
        User.setPassword(passwordEncoder.encode(request.getPassword()));

        // Generar nombre simple del email (parte antes del @)
        String name = request.getEmail().split("@")[0];
        User.setName(name);

        // Guardar usuario en la base de datos
        userRepository.save(User);

        // Generar token JWT
        String jwtToken = jwtService.generateToken(User);

        // Crear respuesta
        AuthResponse response = new AuthResponse();
        response.setToken(jwtToken);
        response.setMessage("Usuario registrado exitosamente");

        return response;
    }

    @Override
    public AuthResponse authenticate(AuthRequest request) {
        // Autenticar usuario con Spring Security
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        // Obtener usuario de la base de datos
        user User = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        // Generar token JWT
        String jwtToken = jwtService.generateToken(User);

        // Crear respuesta
        AuthResponse response = new AuthResponse();
        response.setToken(jwtToken);
        response.setMessage("Autenticación exitosa");

        return response;
    }
}