package org.myungkeun.spring_blog.services.impl;

import io.jsonwebtoken.Claims;
import org.myungkeun.spring_blog.services.JwtService;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Map;
import java.util.function.Function;

public class JwtServiceImpl implements JwtService {
    @Override
    public String extractUsername(String name) {
        return null;
    }

    @Override
    public <T> T extractClaim(String token, Function<Claims, T> claimResolver) {
        return null;
    }

    @Override
    public String generateToken(UserDetails userDetails) {
        return null;
    }

    @Override
    public String generateToken(Map<String, Object> extraClaims, UserDetails userDetails) {
        return null;
    }

    @Override
    public String generateRefreshToken(UserDetails userDetails) {
        return null;
    }

    @Override
    public boolean isTokenValid(String token, UserDetails userDetails) {
        return false;
    }
}
