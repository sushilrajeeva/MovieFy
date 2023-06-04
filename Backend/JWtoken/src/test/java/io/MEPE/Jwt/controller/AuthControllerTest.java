package io.MEPE.Jwt.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;

import io.MEPE.Jwt.entity.User;
import io.MEPE.Jwt.security.JWTUtil;

@RunWith(MockitoJUnitRunner.class)
public class AuthControllerTest {

	@Mock
	private PasswordEncoder passwordEncode;
	@Mock
	private AuthenticationManager authManager;
	
	@Rule
	public MockitoRule rule = MockitoJUnit.rule();

	
	
	@Test
	void AuthTest()
	{
		User user=new User();
		user.setFullName("Aditya Parihar");
		user.setUserId(1);
		user.setUserRole("user");
		user.setEmail("email@gmail.com");
		user.setPassword("password");
		user.setSecretQuestion("Apple");
		
		String encodedPass = user.getPassword();
		user.setPassword(encodedPass);
		JWTUtil jwtUtil = new JWTUtil();
		String token = jwtUtil.generateToken(user.getEmail(), user.getUserRole());
		assertNotNull(token);
	}

	@Test
	void loginTest()
	{
		User user=new User();
		user.setFullName("Aditya Parihar");
		user.setUserId(1);
		user.setUserRole("user");
		user.setEmail("email@gmail.com");
		user.setPassword("password");
		user.setSecretQuestion("Apple");
		
		String encodedPass = user.getPassword();
		user.setPassword(encodedPass);
		JWTUtil jwtUtil = new JWTUtil();
		String token = jwtUtil.generateToken(user.getEmail(), user.getUserRole());
		assertNotNull(token);
	}

}
