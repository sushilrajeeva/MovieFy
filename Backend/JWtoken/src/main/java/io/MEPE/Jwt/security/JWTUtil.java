package io.MEPE.Jwt.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;


@Component
public class JWTUtil {

	@Value("${jwt_secret}")
	private String secret;

	public String generateToken(String email, String role) throws IllegalArgumentException, JWTCreationException {
		return JWT.create().withSubject("User Details").withClaim("email", email).withClaim("role", role)
				.withIssuedAt(new Date()).withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 60 * 240))
				.withIssuer("RealEstate").sign(Algorithm.HMAC256(secret));
	}

	public String validateTokenAndRetrieveSubject(String token) throws JWTVerificationException {
		JWTVerifier verifier = JWT.require(Algorithm.HMAC256(secret)).withSubject("User Details")
				.withIssuer("RealEstate").build();
		DecodedJWT jwt = verifier.verify(token);
		return jwt.getClaim("email").asString();
	}
	
	
	public Boolean validateToken(String token) throws JWTVerificationException{
		try {
			JWTVerifier verifier = JWT.require(Algorithm.HMAC256(secret)).withSubject("User Details")
					.withIssuer("RealEstate").build();
			verifier.verify(token);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	
	}

}