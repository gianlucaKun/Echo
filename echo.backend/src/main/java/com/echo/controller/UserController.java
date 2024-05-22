package com.echo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.echo.dto.UserDto;
import com.echo.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

	
	@Autowired
	private UserService uService;

	@GetMapping("/find")
	public UserDto findbyId (@RequestParam("id") Long id) {
		
		return uService.findByIdService(id);
	}
}
