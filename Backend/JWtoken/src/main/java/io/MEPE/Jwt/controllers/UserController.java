package io.MEPE.Jwt.controllers;

import java.util.Collections;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.MEPE.Jwt.entity.User;
import io.MEPE.Jwt.repository.UserRepo;


@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserController {

	@Autowired
	private UserRepo userRepo;

	@GetMapping("/info")
	public User getUserDetails() {
		String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return userRepo.findByEmail(email).get();
	}

	@GetMapping("/role")
	public String getroleDetails() {
		String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		User data = userRepo.findByEmail(email).get();
		return data.getUserRole();

	}
	
	@GetMapping("/email")
	public Map<String, Object> getEmail() {
		String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return Collections.singletonMap("email", email);

	}
	
	@GetMapping("/userRole")
	public Map<String, String> getrole() {
		String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		User data = userRepo.findByEmail(email).get();
		return Collections.singletonMap("role", data.getUserRole());
	}
}