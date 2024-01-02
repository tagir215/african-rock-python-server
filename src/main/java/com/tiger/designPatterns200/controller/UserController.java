package com.tiger.designPatterns200.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tiger.designPatterns200.exception.user.LoginException;
import com.tiger.designPatterns200.exception.user.RegistrationException;
import com.tiger.designPatterns200.model.user.AuthenticationResponse;
import com.tiger.designPatterns200.model.user.LoginDTO;
import com.tiger.designPatterns200.model.user.RegistrationDTO;
import com.tiger.designPatterns200.service.user.LoginService;
import com.tiger.designPatterns200.service.user.RegistrationService;

/**
 * @author OMISTAJA
 * authentication controller
 */
@RestController
public class UserController {

	private RegistrationService registrationService;
	private LoginService loginService;


	public UserController(RegistrationService registrationService, LoginService loginService) {
		this.registrationService = registrationService;
		this.loginService = loginService;
	}

	/**
	 * @param dto
	 * @return
	 * @throws RegistrationException
	 */
	@PostMapping("/registration")
	public AuthenticationResponse register(@RequestBody RegistrationDTO dto) throws RegistrationException {
		return registrationService.register(dto);
	}
	
	/**
	 * @param dto
	 * @return 
	 * @throws LoginException
	 */
	@PostMapping("/login")
	public AuthenticationResponse login(@RequestBody LoginDTO dto) throws LoginException {
		return loginService.login(dto);
	}
	
	/**
	 * 
	 * @return boolean based on if authenticated
	 */
	@GetMapping("api/v1/user/status")
	public String checkStatus() {
		return "authoritized";
	}
}
