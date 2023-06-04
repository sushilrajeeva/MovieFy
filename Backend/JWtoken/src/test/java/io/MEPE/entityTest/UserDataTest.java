package io.MEPE.entityTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import io.MEPE.Jwt.entity.User;



 
public class UserDataTest {

	User auth = new User();
	@Test
	void testPassword() {
		auth.setPassword("Name");
		assertEquals( "Name", auth.getPassword());
	}
	
	@Test
	void testEmail() {
		auth.setEmail("Name");
		assertEquals( "Name", auth.getEmail());
	}
	
	@Test
	void testFullName() {
		auth.setFullName("Name@gmail.com");
		assertEquals( "Name@gmail.com", auth.getFullName());
	}
	
	@Test
	void testRole() {
		auth.setUserRole("User");
		assertEquals( "User", auth.getUserRole());
	}
	
	@Test
	void testSecretQuestion() {
		auth.setSecretQuestion("Apple");
		assertEquals("Apple", auth.getSecretQuestion());
	}
	

}
