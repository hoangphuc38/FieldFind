package com.phuch.fieldfind.security;

import com.phuch.fieldfind.models.constants.Constant;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;

@Component
public class JwtTokenProvider {
    @Value("${app.jwt-secret}")
    private String jwtSecret;

    public String generateToken(String username){
        return createToken(username, Constant.ACCESS_TOKEN_VALIDITY_SECONDS);
    }

    public String generateRefreshToken(String username){
        return createToken(username, Constant.REFRESH_TOKEN_VALIDITY_SECONDS);
    }

    public String createToken(String username, Long expiredTime){
        Date currentDate = new Date();

        Date expireDate = new Date(currentDate.getTime() + expiredTime);

        return Jwts.builder()
                .subject(username)
                .issuedAt(currentDate)
                .expiration(expireDate)
                .signWith(getKey())
                .compact();
    }

    public String getUserNameFromToken(String token){
        return Jwts.parser()
                .verifyWith((SecretKey) getKey())
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }


    public boolean validateToken(String token){
        return isTokenExpired(token);
    }

    private boolean isTokenExpired(String token){
        Date expiredDate = Jwts.parser()
                .verifyWith((SecretKey) getKey())
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getExpiration();

        return expiredDate != null && expiredDate.before(new Date());
    }

    private Key getKey(){
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
    }
}
