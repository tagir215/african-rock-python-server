package com.tiger.designPatterns200.service.user;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.tiger.designPatterns200.exception.user.RegistrationException;
import com.tiger.designPatterns200.model.user.AuthenticationResponse;
import com.tiger.designPatterns200.model.user.RegistrationDTO;

@SpringBootTest
@Transactional
class RegistrationServiceTest {

	@Autowired
	RegistrationService service;

	@Test
	void test() {
		var dto = new RegistrationDTO();
		dto.setFirstname("mike");
		dto.setLastname("plishkin");
		dto.setEmail("test@gmail.com");
		dto.setPassword("password");
		dto.setPasswordRepeated("password");
		
		
		try {
			AuthenticationResponse response = service.register(dto);
			Assertions.assertNotNull(response.getToken());
		} catch (RegistrationException e) {
			e.printStackTrace();
		}
	}

}
