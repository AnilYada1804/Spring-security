package com.spring.security.api.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.util.ReflectionTestUtils;

import com.spring.security.api.dto.UserDto;
import com.spring.security.api.model.User;
import com.spring.security.api.service.CustomUserDetailsService;

@RunWith(MockitoJUnitRunner.class)
public class AdminControllerTest {

	private AdminController adminController;

	@Mock
	private CustomUserDetailsService userSerice;

	@Before
	public void setUp() {
		adminController = new AdminController();
		ReflectionTestUtils.setField(adminController, "userSerice", userSerice);
	}

	@Test
	public void test_getAllUsers() {
		User user = mockUser();
		List<UserDto> users = Arrays.asList(new UserDto(user));
		doReturn(users).when(userSerice).getAllUsers();
		ResponseEntity<List<UserDto>> actual = adminController.getAllUsers();
		assertEquals(actual.getStatusCode(), HttpStatus.OK);
	}

	@Test
	public void test_addUserByAdmin() {
		ResponseEntity<UserDto> expected = adminController.addUserByAdmin(mockUser());
		assertEquals(expected.getStatusCode(), HttpStatus.OK);
	}

	@Test
	public void test_getUserById_negativeScenario() {
		ResponseEntity<UserDto> expected = adminController.getUserById(Mockito.anyInt());
		assertEquals(expected.getStatusCode(), HttpStatus.NOT_FOUND);
	}

	@Test
	public void test_getUserById_positiveScenario() {
		Optional<User> optionalUser = Optional.of(new User());
		doReturn(optionalUser).when(userSerice).findById(Mockito.anyInt());
		ResponseEntity<UserDto> expected = adminController.getUserById(Mockito.anyInt());
		assertEquals(expected.getStatusCode(), HttpStatus.OK);
	}

	@Test
	public void test_deleteUser() {
		ResponseEntity<?> expected = adminController.deleteUser(Mockito.anyInt());
		assertEquals(expected.getStatusCode(), HttpStatus.NOT_FOUND);
	}

	@Test
	public void test_deleteUser_possitiveScenario() {
		Optional<User> optionalUser = Optional.of(new User());
		doReturn(optionalUser).when(userSerice).findById(Mockito.anyInt());
		ResponseEntity<?> expected = adminController.deleteUser(100);
		assertEquals(expected.getStatusCode(), HttpStatus.OK);
	}

	@Test
	public void test_updateUser() {
		Optional<User> optionalUser = Optional.of(new User());
		doReturn(optionalUser).when(userSerice).findById(Mockito.anyInt());
		ResponseEntity<UserDto> expected = adminController.updateUser(100, new UserDto());
		assertEquals(expected.getStatusCode(), HttpStatus.OK);
	}

	@Test
	public void test_updateUser_negativeScenario() {
		ResponseEntity<UserDto> expected = adminController.updateUser(100, new UserDto());
		assertEquals(expected.getStatusCode(), HttpStatus.NOT_FOUND);
	}

	private User mockUser() {
		User user = new User();
		user.setEmail("test");
		user.setUser_id(100);
		return user;
	}
}
