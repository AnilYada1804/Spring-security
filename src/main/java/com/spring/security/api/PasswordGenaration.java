package com.spring.security.api;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordGenaration {
	public static void main(String[] args) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

		System.out.println(encoder.encode("anil"));
	}
}
