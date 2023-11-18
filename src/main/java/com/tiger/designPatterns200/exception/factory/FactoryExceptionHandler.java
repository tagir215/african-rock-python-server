package com.tiger.designPatterns200.exception.factory;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class FactoryExceptionHandler {
	@ExceptionHandler(FactoryRegistryException.class)
	public ResponseEntity<Object> handleFactoryNotFoundException(FactoryRegistryException e) {
	    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
	}

}
