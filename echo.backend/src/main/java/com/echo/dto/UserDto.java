package com.echo.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDto {

	private Long id;

	private String name;
	private String surname;
	private String password; // togliere  
	private String username;
	private String imgUrl;
	private String email;
	private LocalDate dateOfBirth;
	private String location;
	private LocalDate registrationDate;

	private Long roleId;
}


// For mapping from DTO to Entity, you need to handle username and password separately
//@Mapping(target = "username", ignore = true)