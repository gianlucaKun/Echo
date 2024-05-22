package com.echo.user.dto;

import java.time.LocalDate;

import com.echo.user.entity.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

	private Long id;
	
	private String name;
	private String surname;
	private String password;
	private String username;
	private String imgUrl;
	private String email;
    private LocalDate dateOfBirth;
    private String location;
    private LocalDate registrationDate;
	private Role role;
}
