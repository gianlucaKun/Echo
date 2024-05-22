package com.echo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.echo.dto.UserDto;
import com.echo.security.JwtService;
import com.echo.service.UserService;

@RestController
public class LoginController {

	@Autowired
	private UserService uService;
	
	@Autowired
	private JwtService jwtService;

	@PostMapping("/login")
	private ResponseEntity<?> loginController(@RequestBody UserDto user) {
		boolean authenticationResult = uService.loginService(user);

		if (authenticationResult) {

			String token = jwtService.generateToken(user.getUsername());

			return ResponseEntity.ok(Map.of("token", token));
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Autenticazione fallita");
		}
	}
	
	@PostMapping("/register")
	private UserDto createUserController (@RequestBody UserDto user) {
		if(user.getRoleId() == null) {
			user.setRoleId((long) 2);
		}
		return uService.createUserService(user);		
	}

}