package io.MEPE.security;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import io.MEPE.Jwt.security.JWTUtil;

@SpringBootTest
public class JwtUtilTest {

	
	JWTUtil jwtUtil;

	@Test
	void generateToken() {
		String generateToken = jwtUtil.generateToken("ramandeeps489@gmail.com", "manager");
		
		assertNotNull(generateToken);
	}
	@Test
	void validateToken() {
		String  generateToken = jwtUtil.generateToken("ramandeeps489@gmail.com", "manager");
		String check=jwtUtil.validateTokenAndRetrieveSubject(generateToken);
		assertNotNull(check);
	}
}
