package com.echo.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.echo.dto.UserDto;
import com.echo.entity.User;

@Mapper
public interface UserMapper {
    
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(source = "roleId", target = "role.id")
    User toEntity(UserDto dto);

    @Mapping(source = "role.id", target = "roleId")
    UserDto toDto(User entity);

    List<User> toEntityList(List<UserDto> dtoList);

    List<UserDto> toDtoList(List<User> entityList);
}

