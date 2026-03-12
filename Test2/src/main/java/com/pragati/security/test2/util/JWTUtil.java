package com.pragati.security.test2.util;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;
import java.util.Set;

public class JWTUtil {

    // MUST be >= 32 bytes for HS256
    private static final String SECRET =
            "this_is_a_demo_secret_key_32_chars_minimum!!";

    private static final Key KEY =
            Keys.hmacShaKeyFor(SECRET.getBytes(StandardCharsets.UTF_8));

    public static String generateToken(String username, Set<String> roles) {
        long now = System.currentTimeMillis();

        return Jwts.builder()
                .setSubject(username)
                .claim("roles", roles)
                .setIssuedAt(new Date(now))
                .setExpiration(new Date(now + 60 * 60 * 1000)) // 1 hour
                .signWith(KEY, SignatureAlgorithm.HS256)
                .compact();
    }

    public static Jws<Claims> parse(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(KEY)
                .build()
                .parseClaimsJws(token);
    }
}
