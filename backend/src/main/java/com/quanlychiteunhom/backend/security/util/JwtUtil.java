package com.quanlychiteunhom.backend.security.util;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;

@Component
public class JwtUtil {

	@Value("${spring.app.jwtSecret}")
    String secretKey;

	@Value("${spring.app.jwtExpirationMs}")
	String expirationTime;

	public String getJwtFromHeader(HttpServletRequest request) {
		String bearerToken = request.getHeader("Authorization");
		if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
			return bearerToken.substring(7);
		}
		return null;
	}

	public String generateTokenFromUsername(UserDetails userDetails) {
		String username = userDetails.getUsername();
		return Jwts.builder()
				.subject(username)
				.issuedAt(new Date())
				.expiration(new Date(System.currentTimeMillis() + Long.parseLong(expirationTime)))
				.signWith(key())
				.compact();
	}

	public String getusernameFromJwt(String token) {
		return Jwts.parser()
				.verifyWith((SecretKey) key())
				.build()
				.parseSignedClaims(token)
				.getPayload()
				.getSubject();
	}

	public boolean validateToken(String token) {
		try {
			Jwts.parser()
				.verifyWith((SecretKey) key())
				.build()
				.parseSignedClaims(token);
			return true;
		} catch (MalformedJwtException e) {
			System.out.print("Invalid JWT token" + e.getMessage());
		} catch (ExpiredJwtException e) {
			System.out.print("JWT token expired" + e.getMessage());
		} catch (UnsupportedJwtException e) {
			System.out.print("JWT token is unsupported" + e.getMessage());
		} catch (IllegalArgumentException e) {
			System.out.print("JWT is empty" + e.getMessage());
		}
		return false;
	}

	private Key key() {
		return Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretKey));
	}
}
