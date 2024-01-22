package com.tiger.designPatterns200.service.user;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.tiger.designPatterns200.entity.user.AppUser;
import com.tiger.designPatterns200.exception.user.RegistrationException;
import com.tiger.designPatterns200.repository.user.UserRepository;
import com.tiger.designPatterns200.security.JwtService;

@Service
public class UserService implements UserDetailsService{
	private final String USER_NOT_FOUND_MSG = "user with email % not found";
	private final UserRepository repository;
	private final PasswordEncoder bcryptPasswordEncoder;



	public UserService(UserRepository repository, PasswordEncoder bcryptPasswordEncoder, JwtService jwtService) {
		this.repository = repository;
		this.bcryptPasswordEncoder = bcryptPasswordEncoder;
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		return repository.findByEmail(email)
				.orElseThrow(() -> new UsernameNotFoundException(USER_NOT_FOUND_MSG));
	}

	public AppUser singUpUser(AppUser user) throws RegistrationException {
		boolean userExists = repository
				.findByEmail(user.getEmail())
				.isPresent();
		if(userExists) {
			throw new RegistrationException("email already taken");
		}
		
		String encodedPassword = bcryptPasswordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);

		repository.save(user);
		
		return user;
	}
	
	
	public int enableAppUser(String email) {
        return repository.enableAppUser(email);
    }
}
