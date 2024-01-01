package com.tiger.designPatterns200.service.user;

import org.springframework.stereotype.Service;

import com.tiger.designPatterns200.entity.user.AppUser;
import com.tiger.designPatterns200.exception.user.RegistrationException;
import com.tiger.designPatterns200.model.user.AppUserRole;
import com.tiger.designPatterns200.model.user.AuthenticationResponse;
import com.tiger.designPatterns200.model.user.RegistrationDTO;
import com.tiger.designPatterns200.repository.user.UserRepository;

@Service
public class RegistrationService {

	private final EmailValidator emailValidator;
	private final UserService userService;

	
	public RegistrationService(EmailValidator emailValidator, UserService appUserService, UserRepository appUserRepository) {
		this.emailValidator = emailValidator;
		this.userService = appUserService;
	}

	public AuthenticationResponse register(RegistrationDTO request) throws RegistrationException {
		boolean isValidEmail = emailValidator.test(request.getEmail());
		if(!isValidEmail) {
			throw new RegistrationException("email not valid");
		}
		if(!request.getPassword().equals(request.getPasswordRepeated())) {
			throw new RegistrationException("passwords don't match");
		}
		AuthenticationResponse response = userService.singUpUser(
				new AppUser(
						request.getFirstname(),
						request.getLastname(),
						request.getEmail(),
						request.getPassword(),
						AppUserRole.USER	
						));
		
		return response;
	}
	
}
