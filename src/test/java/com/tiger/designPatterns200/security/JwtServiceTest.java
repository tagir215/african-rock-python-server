package com.tiger.designPatterns200.security;

import java.security.SecureRandom;
import java.util.Base64;

import org.junit.jupiter.api.Test;

class JwtServiceTest {

	@Test
	void generateSecret() {
		byte[] randomBytes = new byte[32]; 
		SecureRandom secureRandom = new SecureRandom();
		secureRandom.nextBytes(randomBytes);
		String secretKey = Base64.getEncoder().encodeToString(randomBytes);
		System.out.println("Generated Secret Key: " + secretKey);
	}

}
