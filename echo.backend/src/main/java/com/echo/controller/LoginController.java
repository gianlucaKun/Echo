package com.echo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.echo.dto.UserDto;
import com.echo.entity.User;
import com.echo.security.JwtService;
import com.echo.service.UserService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class LoginController {

	@Autowired
	private UserService uService;
	
	@Autowired
	private JwtService jwtService;
	
//	@Autowired
//	private GeoLocationService geoLocationService;

	@PostMapping("/login")
	private ResponseEntity<?> loginController(@RequestBody User user) {
		boolean authenticationResult = uService.loginService(user);

		if (authenticationResult) {

			String token = jwtService.generateToken(user.getUsername());

			return ResponseEntity.ok(Map.of("token", token));
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Autenticazione fallita");
		}
	}
	
	@PostMapping("/register")
	private UserDto createUserController (@RequestBody User user,  HttpServletRequest request) {

		//CODE GEOLOCALIZZAZIONE
		
//        String ipAddress = request.getRemoteAddr();
//        if (ipAddress.equals("0:0:0:0:0:0:0:1")) {
//            ipAddress = "78.208.255.176"; // Indirizzo IP di iphone
//        }
//        System.out.println("ipAddress " + ipAddress);                                        
//        GeoLocation geoLocation = geoLocationService.getGeoLocation(ipAddress);
//
//        System.out.println("geoLocation " + geoLocation.getCity());
//        
//        user.setLocation(geoLocation.getCity());
        
//		if(user.getRole().getId() == null) {
//			user.setRole().setId((long) 2);
//		}
		return uService.createUserService(user);		
	}
	
	 @PostMapping("/usernamePresent")
	    public boolean usernameIsPresent(@RequestBody Map<String, String> request) {
	        return uService.usernameIsPresent(request.get("username"));
	    }

	    @PostMapping("/emailPresent")
	    public boolean emailIsPresent(@RequestBody Map<String, String> request) {
	        return uService.emailIsPresent(request.get("email"));
	    }
}
