package com.tiger.designPatterns200.service.user;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.tiger.designPatterns200.exception.user.LoginException;
import com.tiger.designPatterns200.model.user.AuthenticationResponse;
import com.tiger.designPatterns200.model.user.LoginDTO;
import com.tiger.designPatterns200.security.JwtService;

@Service
public class LoginService {

	private UserService userService;
	private AuthenticationManager authenticationManager;
	private JwtService jwtService;

	public LoginService(AuthenticationManager authenticationManager, UserService userService, JwtService jwtService) {
		this.authenticationManager = authenticationManager;
		this.userService = userService;
		this.jwtService = jwtService;
	}


	public AuthenticationResponse login(LoginDTO request) throws LoginException {
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(
						request.getUsername()
						,request.getPassword()
						)
				);
		UserDetails userDetails = userService.loadUserByUsername(request.getUsername());
		String jwtToken = jwtService.generateToken(userDetails);
		return new AuthenticationResponse(jwtToken);
	}
}
