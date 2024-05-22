package com.echo.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.echo.service.UserService;

public class UserController {

	
	@Autowired
	private UserService uService;
}
