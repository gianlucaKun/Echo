package com.echo.mapper;

import com.echo.dto.UserDto;
import com.echo.entity.Role;
import com.echo.entity.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-22T12:07:01+0200",
    comments = "version: 1.3.1.Final, compiler: Eclipse JDT (IDE) 3.37.0.v20240215-1558, environment: Java 22.0.1 (Eclipse Adoptium)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User toEntity(UserDto dto) {
        if ( dto == null ) {
            return null;
        }

        User user = new User();

        user.setRole( userDtoToRole( dto ) );
        user.setDateOfBirth( dto.getDateOfBirth() );
        user.setEmail( dto.getEmail() );
        user.setId( dto.getId() );
        user.setImgUrl( dto.getImgUrl() );
        user.setLocation( dto.getLocation() );
        user.setName( dto.getName() );
        user.setPassword( dto.getPassword() );
        user.setRegistrationDate( dto.getRegistrationDate() );
        user.setSurname( dto.getSurname() );
        user.setUsername( dto.getUsername() );

        return user;
    }

    @Override
    public UserDto toDto(User entity) {
        if ( entity == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setRoleId( entityRoleId( entity ) );
        userDto.setDateOfBirth( entity.getDateOfBirth() );
        userDto.setEmail( entity.getEmail() );
        userDto.setId( entity.getId() );
        userDto.setImgUrl( entity.getImgUrl() );
        userDto.setLocation( entity.getLocation() );
        userDto.setName( entity.getName() );
        userDto.setPassword( entity.getPassword() );
        userDto.setRegistrationDate( entity.getRegistrationDate() );
        userDto.setSurname( entity.getSurname() );
        userDto.setUsername( entity.getUsername() );

        return userDto;
    }

    @Override
    public List<User> toEntityList(List<UserDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<User> list = new ArrayList<User>( dtoList.size() );
        for ( UserDto userDto : dtoList ) {
            list.add( toEntity( userDto ) );
        }

        return list;
    }

    @Override
    public List<UserDto> toDtoList(List<User> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<UserDto> list = new ArrayList<UserDto>( entityList.size() );
        for ( User user : entityList ) {
            list.add( toDto( user ) );
        }

        return list;
    }

    protected Role userDtoToRole(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        Role role = new Role();

        role.setId( userDto.getRoleId() );

        return role;
    }

    private Long entityRoleId(User user) {
        if ( user == null ) {
            return null;
        }
        Role role = user.getRole();
        if ( role == null ) {
            return null;
        }
        Long id = role.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
