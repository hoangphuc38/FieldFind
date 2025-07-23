package com.phuch.fieldfind.services.impl;

import com.phuch.fieldfind.models.dtos.LoginDto;
import com.phuch.fieldfind.models.responses.AuthResponse;
import com.phuch.fieldfind.security.JwtTokenProvider;
import com.phuch.fieldfind.services.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;

    @Override
    public ResponseEntity<AuthResponse> login(LoginDto loginDto) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getEmail(),
                loginDto.getPassword()
        ));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtTokenProvider.generateToken(loginDto.getEmail());
        String refreshToken = jwtTokenProvider.generateRefreshToken(loginDto.getEmail());

        return ResponseEntity.ok(new AuthResponse(token, refreshToken));
    }
}
