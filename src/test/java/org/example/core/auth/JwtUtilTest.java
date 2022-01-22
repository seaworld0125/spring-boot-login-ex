package org.example.core.auth;

import static org.junit.jupiter.api.Assertions.*;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import java.time.Instant;
import java.util.Date;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class JwtUtilTest {

    @DisplayName("1. Access 토큰의 정상 생성 확인")
    @Test
    void createAuthToken() {
        String token = JwtUtil.createAuthToken("test");
        TokenResult tokenResult = JwtUtil.verifyToken(token);
        assertTrue(tokenResult.isSuccess());
        assertEquals(tokenResult.getName(), "test");
    }

    @DisplayName("2. Refresh 토큰의 정상 생성 확인")
    @Test
    void createRefreshToken() {
        String token = JwtUtil.createRefreshToken("test");
        TokenResult tokenResult = JwtUtil.verifyToken(token);
        assertTrue(tokenResult.isSuccess());
        assertEquals(tokenResult.getName(), "test");
    }

    @DisplayName("3. 비정상 토큰을 분류할 수 있는지 확인")
    @Test
    void verifyToken() {
        String invalidToken = JWT.create().withExpiresAt(new Date())
                .sign(Algorithm.HMAC512("key-DND-team10"));
        TokenResult tokenResult = JwtUtil.verifyToken(invalidToken);
        assertFalse(tokenResult.isSuccess());
    }

    @Test
    void authTime() {
        Date now = new Date();
        System.out.println(">>> " + now);
        System.out.println(">>> " + new Date(now.getTime() + (1000 * 60 * 30)));
    }
}