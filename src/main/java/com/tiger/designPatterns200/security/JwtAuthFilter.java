package com.tiger.designPatterns200.security;

import java.io.IOException;

import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthFilter extends OncePerRequestFilter {
	
	private final JwtService jwtService; 
	private final UserDetailsService userDetailsService;
	
	
	
	public JwtAuthFilter(JwtService jwtService, UserDetailsService userDetailsService) {
		this.jwtService = jwtService;
		this.userDetailsService = userDetailsService;
	}



	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String header = request.getHeader("Authorization");
		if(header != null) {
			String[] elements = header.split(" ");
			if(elements.length ==2 && "Bearer".equals(elements[0])) {
				String token = elements[1];
				String username = jwtService.extractUsername(token);
				if(username!=null && SecurityContextHolder.getContext().getAuthentication() == null) {
					UserDetails userDetails = userDetailsService.loadUserByUsername(username);
					if(jwtService.isTokenValid(token, userDetails)) {
						var authToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
						authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
						SecurityContextHolder.getContext().setAuthentication(authToken);
					}
				}
			}
		}

		filterChain.doFilter(request, response);
		
	}

}
