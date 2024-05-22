package com.echo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.echo.entity.Role;
import com.echo.repository.RoleRepository;

@Service
public class RoleService {

	@Autowired
	private RoleRepository rRepository;
	
	public  Role createRoleService (Role role) {
		Role saved = rRepository.save(role);
		return saved;
	}
}
