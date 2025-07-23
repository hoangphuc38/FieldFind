package com.phuch.fieldfind.services;

import com.phuch.fieldfind.models.dtos.LoginDto;
import com.phuch.fieldfind.models.responses.AuthResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface AuthService {
    ResponseEntity<AuthResponse> login(LoginDto loginDto);
}
