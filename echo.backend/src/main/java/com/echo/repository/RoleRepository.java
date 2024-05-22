package com.echo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.echo.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{

}
