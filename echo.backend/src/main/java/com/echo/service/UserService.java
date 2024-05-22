package com.echo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.echo.dto.UserDto;
import com.echo.entity.User;
import com.echo.mapper.UserMapper;
import com.echo.repository.UserRepository;


@Service
public class UserService {

	
	@Autowired
	private UserRepository uRepository;
	
	@Autowired
	private UserMapper uMapper;

	public boolean loginService(UserDto user) {

		User findUser = uRepository.findByUsername(user.getUsername());
		
		if (findUser != null & findUser.getPassword().equals(user.getPassword())) {
			
			return true;
		} else {
			return false;
		}
	}

	public UserDto createUserService(UserDto user) {
		User saved = uMapper.toEntity(user);
		uRepository.save(saved);
		return uMapper.toDto(saved);
	}

	public UserDto findByIdService(Long id) {
		
		User finded = uRepository.findById(id).orElse(null);
		
		if (finded != null ) {
			return uMapper.toDto(finded);	
		} else {
			return null;
		}
	}
}
