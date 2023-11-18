package com.tiger.designPatterns200.service.user;

import org.springframework.stereotype.Service;

import com.tiger.designPatterns200.entity.user.AppUser;
import com.tiger.designPatterns200.exception.user.RegistrationException;
import com.tiger.designPatterns200.model.user.AppUserRole;
import com.tiger.designPatterns200.model.user.RegistrationRequest;

@Service
public class RegistrationService {

	private final EmailValidator emailValidator;
	private final AppUserService appUserService;

	
	public RegistrationService(EmailValidator emailValidator, AppUserService appUserService) {
		this.emailValidator = emailValidator;
		this.appUserService = appUserService;
	}

	public String register(RegistrationRequest request) throws RegistrationException {
		boolean isValidEmail = emailValidator.test(request.getEmail());
		if(!isValidEmail) {
			throw new RegistrationException("email not valid");
		}
		String token = appUserService.singUpUser(
				new AppUser(
						request.getFirstName(),
						request.getLastName(),
						request.getEmail(),
						request.getPassword(),
						AppUserRole.USER	
						));
		
		return token;
	}
	
}
