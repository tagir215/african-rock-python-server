package com.tiger.designPatterns200.service.user;

import java.util.function.Predicate;

import org.springframework.stereotype.Service;

@Service
public class EmailValidator implements Predicate<String> {

	@Override
	public boolean test(String t) {
		// TODO Auto-generated method stub
		return true;
	}

}
