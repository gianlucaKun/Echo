package com.echo.entity;


import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
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
    
    @ManyToOne
	private Role role;
    
    @PrePersist
    protected void prePersist() {
        if (this.registrationDate == null) {
            this.registrationDate = LocalDate.now();
        }
    }

}
