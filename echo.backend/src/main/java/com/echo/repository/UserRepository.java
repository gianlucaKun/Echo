package com.echo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.echo.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsername(String username);

}
