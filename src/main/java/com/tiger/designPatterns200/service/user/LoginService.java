package com.tiger.designPatterns200.service.user;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.tiger.designPatterns200.entity.user.AppUser;
import com.tiger.designPatterns200.exception.user.LoginException;
import com.tiger.designPatterns200.model.user.LoginRequest;
import com.tiger.designPatterns200.repository.user.AppUserRepository;

@Service
public class LoginService {

	private final AppUserRepository repository;
	private BCryptPasswordEncoder encoder;

	public LoginService(AppUserRepository repository, BCryptPasswordEncoder encoder) {
		this.repository = repository;
		this.encoder = encoder;
	}


	public String login(LoginRequest request) throws LoginException {
		AppUser user = repository.findByEmail(request.getUserName())
				.orElseThrow(()-> new LoginException("user not found"));
		
		if(!encoder.matches(request.getPassword(),user.getPassword())) {
			throw new LoginException("wrong password");
		}
		return "success";
	}
}
