package com.spring.security.api.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RunWith(MockitoJUnitRunner.class)
public class AuthenticationControllerTest {
	
	private AuthenticationController authenticationController ;
	
	@Before
	public void setUp() {
		authenticationController = new AuthenticationController();
	}
	
	@Test
	public void test_process() {
		ResponseEntity<String> actual = authenticationController.process();
		assertEquals(actual.getBody(), "Login successfully :)");
		assertEquals(actual.getStatusCode(), HttpStatus.OK);
	}

}
