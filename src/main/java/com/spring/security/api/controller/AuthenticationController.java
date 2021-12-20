package com.spring.security.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

	@GetMapping("/permitAllRoles")
	public ResponseEntity<String> process() {
		return new ResponseEntity<String>("Login successfully :)", HttpStatus.OK);
	}
}
