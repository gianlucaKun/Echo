package com.echo.mapper;


import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.echo.dto.UserDTO;
import com.echo.entity.User;

@Mapper
public interface UserMapper {

	@Mapping(source = "roleId", target = "role.id")
	User toEntity ( UserDTO dto );
	
	@Mapping(source = "role.id", target = "roleId")
	UserDTO toDto ( User entity );
	
	
	List<User> toEntityList ( List<UserDTO> dto );
	
	List<UserDTO> toDtoList ( List<User> entity );

}
