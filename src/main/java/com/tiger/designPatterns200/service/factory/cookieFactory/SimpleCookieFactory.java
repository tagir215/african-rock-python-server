package com.tiger.designPatterns200.service.factory.cookieFactory;

import java.util.UUID;

import org.springframework.stereotype.Component;

import jakarta.servlet.http.Cookie;

@Component
public class SimpleCookieFactory {

	public Cookie createSessionCookie() {
		String name = "sessionId";
		String value = UUID.randomUUID().toString();
		Cookie cookie = new Cookie(name,value);
		cookie.setSecure(false);
		cookie.setPath("/");
		return cookie;
	}
}
