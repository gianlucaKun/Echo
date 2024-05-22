package com.echo.security.filter;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.echo.security.JwtService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class Filter implements jakarta.servlet.Filter {

	@Autowired
	private JwtService jwtService;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletResponse resp = (HttpServletResponse) response;
		HttpServletRequest req = (HttpServletRequest) request;

		String requestURI = req.getRequestURI();
		System.out.println("FILTRO doFilter URI: " + requestURI);

		String token = req.getHeader("Authorization");
		System.out.println("FILTRO doFilter HEADER " + token);

		String requestMethod = req.getMethod();
		System.out.println("FILTRO doFilter METHOD: " + requestMethod);

		if (!requestURI.contains("api")) {
			chain.doFilter(request, response);
			return;
		}

		// Controllo token se contiene api
		if (token == null || token.isEmpty() || !jwtService.isValid(token)) {
			resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			return;
		}

		// Se il token è valido, lascio passare la richiesta
		chain.doFilter(request, response);
	}

}
