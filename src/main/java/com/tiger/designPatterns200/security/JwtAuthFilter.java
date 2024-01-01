package com.tiger.designPatterns200.security;

import java.io.IOException;

import org.springframework.http.HttpHeaders;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtAuthFilter extends OncePerRequestFilter {
	
	private JwtService jwtService; 
	
	public JwtAuthFilter(JwtService jwtService) {
		this.jwtService = jwtService;
	}



	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String header = request.getHeader(HttpHeaders.AUTHORIZATION);
		if(header != null) {
			String[] elements = header.split(" ");
			if(elements.length ==2 && "Bearer".equals(elements[0])) {
				String token = elements[1];
				String username = jwtService.extractUsername(token);
			}
			filterChain.doFilter(request, response);
		}

		
	}

}
