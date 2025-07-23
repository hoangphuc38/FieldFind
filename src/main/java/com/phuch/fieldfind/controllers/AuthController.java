package com.phuch.fieldfind.controllers;

import com.phuch.fieldfind.models.dtos.LoginDto;
import com.phuch.fieldfind.models.responses.AuthResponse;
import com.phuch.fieldfind.services.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${api.prefix}/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@Valid @RequestBody LoginDto loginDto) {
        return authService.login(loginDto);
    }
}
