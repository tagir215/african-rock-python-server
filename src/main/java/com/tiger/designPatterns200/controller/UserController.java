package com.tiger.designPatterns200.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tiger.designPatterns200.exception.user.LoginException;
import com.tiger.designPatterns200.exception.user.RegistrationException;
import com.tiger.designPatterns200.model.user.LoginRequest;
import com.tiger.designPatterns200.model.user.RegistrationRequest;
import com.tiger.designPatterns200.service.user.LoginService;
import com.tiger.designPatterns200.service.user.RegistrationService;

/**
 * @author OMISTAJA
 * login and registration. still incomplete
 */
@RestController
@RequestMapping(path = "api/v1/user")
public class UserController {

	private RegistrationService registrationService;
	private LoginService loginService;


	public UserController(RegistrationService registrationService, LoginService loginService) {
		this.registrationService = registrationService;
		this.loginService = loginService;
	}

	/**
	 * @param request
	 * @return
	 * @throws RegistrationException
	 */
	@PostMapping("/registration")
	public String register(@RequestBody RegistrationRequest request) throws RegistrationException {
		return registrationService.register(request);
	}
	
	/**
	 * @param request
	 * @return
	 * @throws LoginException
	 */
	@PostMapping("/login")
	public String login(@RequestBody LoginRequest request) throws LoginException {
		return loginService.login(request);
	}
}
