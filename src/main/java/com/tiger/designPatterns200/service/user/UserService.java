package com.tiger.designPatterns200.service.user;


import java.util.UUID;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.tiger.designPatterns200.entity.user.AppUser;
import com.tiger.designPatterns200.exception.user.RegistrationException;
import com.tiger.designPatterns200.model.user.AuthenticationResponse;
import com.tiger.designPatterns200.repository.user.UserRepository;
import com.tiger.designPatterns200.security.JwtService;

@Service
public class UserService implements UserDetailsService{
	private final String USER_NOT_FOUND_MSG = "user with email % not found";
	private final UserRepository repository;
	private final BCryptPasswordEncoder bcryptPasswordEncoder;
	private final JwtService jwtService;



	public UserService(UserRepository repository, BCryptPasswordEncoder bcryptPasswordEncoder, JwtService jwtService) {
		this.repository = repository;
		this.bcryptPasswordEncoder = bcryptPasswordEncoder;
		this.jwtService = jwtService;
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		return repository.findByEmail(email)
				.orElseThrow(() -> new UsernameNotFoundException(USER_NOT_FOUND_MSG));
	}

	public AuthenticationResponse singUpUser(AppUser user) throws RegistrationException {
		boolean userExists = repository
				.findByEmail(user.getEmail())
				.isPresent();
		if(userExists) {
			throw new RegistrationException("email already taken");
		}
		
		String encodedPassword = bcryptPasswordEncoder.encode(user.getPassword());
		
		user.setPassword(encodedPassword);
		repository.save(user);
		
		String token = UUID.randomUUID().toString();
		var jwtToken = jwtService.generateToken(user);
		return new AuthenticationResponse(jwtToken);
	}
	
	public int enableAppUser(String email) {
        return repository.enableAppUser(email);
    }
}
