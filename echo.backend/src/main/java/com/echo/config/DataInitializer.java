package com.echo.config;

import org.springframework.stereotype.Component;

import com.echo.entity.Role;
import com.echo.entity.User;
import com.echo.repository.RoleRepository;
import com.echo.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void run(String... args) throws Exception {
    	
        // Controlla se il database è vuoto
        if (userRepository.count() == 0 && roleRepository.count() == 0) {

            Role role1 = new Role();
            role1.setType("ADMIN");
            Role role2 = new Role();
            role2.setType("USER");
            roleRepository.save(role1);
            roleRepository.save(role2);

            User user1 = new User();
            user1.setUsername("CascinaMerlata");
            user1.setPassword("admin");
            user1.setRole(role1);
            userRepository.save(user1);

            User user2 = new User();
            user2.setUsername("Jacopino");
            user2.setPassword("admin");
            user2.setRole(role2);
            userRepository.save(user2);
            
            User user3 = new User();
            user3.setUsername("admin");
            user3.setPassword("admin");
            user3.setRole(role1);
            userRepository.save(user3);
        }
    }
}
