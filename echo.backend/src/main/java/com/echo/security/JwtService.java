package com.echo.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.echo.entity.User;
import com.echo.repository.UserRepository;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtService {

	private static final String SECRET_KEY = "afsergthrjydjyh53g43t34gt5g5hhtrhtrhyrjtmutdmmuymygrnryhrhrthyhbegrgfgdgergetg55y64225y46u7i7";

	private static final long EXPIRATION_TIME = 3600000;
	
	@Autowired
	private UserRepository uRepository;
	
	@SuppressWarnings("deprecation")
	public String generateToken(String username) {
		
		System.out.println("JWTSERVICE generateToken username: " + username);
		
		User u = uRepository.findByUsername(username);
		Date now = new Date();
		Date expiryDate = new Date(now.getTime() + EXPIRATION_TIME);
		
		
		return Jwts.builder()
				.setSubject(username)
				.setIssuedAt(now)
				.claim("id", u.getId())
				.claim("role", u.getRole())
				.setExpiration(expiryDate)
		        .signWith(SignatureAlgorithm.HS512, SECRET_KEY )
				.compact();
	}
	
	public boolean isValid (String token ) {
		
		try {
			Claims claim = parseToken(token);
			System.out.println("JWTSERVICE ISVALID prendo id utente " + claim.get("id"));
			return true;
		} catch (Exception e) {
			System.out.println("JWTSERVICE ISVALID sei entrato nel catch");
			return false;
		}
	}
	
	public static Claims parseToken(String token) {
		return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
	}
}
