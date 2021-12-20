package com.spring.security.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.doReturn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.util.ReflectionTestUtils;

import com.spring.security.api.dto.UserDto;
import com.spring.security.api.model.User;
import com.spring.security.api.repository.UserRepository;
import com.spring.security.api.service.CustomUserDetailsService;

@RunWith(MockitoJUnitRunner.class)
public class CustomUserDetailsServiceTest {

	private CustomUserDetailsService customUserDetailsService;

	@Mock
	private UserRepository repository;

	@Mock
	private BCryptPasswordEncoder passwordEncoder;

	@Before
	public void setUp() {
		customUserDetailsService = new CustomUserDetailsService();
		ReflectionTestUtils.setField(customUserDetailsService, "repository", repository);
		ReflectionTestUtils.setField(customUserDetailsService, "passwordEncoder", passwordEncoder);
	}

	@Test
	public void test_loadUserByUserName() {
		doReturn(mockUser()).when(repository).findByUsername(Mockito.anyString());
		UserDetails expected = customUserDetailsService.loadUserByUsername(Mockito.anyString());
		assertNotNull(expected);
	}

	@Test
	public void test_getAllUsers() {
		List<User> users = new ArrayList<User>();
		users.add(mockUser());
		doReturn(users).when(repository).findAll();
		List<UserDto> usersList = customUserDetailsService.getAllUsers();
		assertNotNull(usersList);
	}

	@Test
	public void test_findById() {
		Optional<User> user = customUserDetailsService.findById(Mockito.anyInt());
		assertNotNull(user);
	}

	@Test
	public void test_deleteUserById() {
		customUserDetailsService.deleteUserById(Mockito.anyInt());
	}

	@Test
	public void test_saveOrUpdate() {
		doReturn(mockUser()).when(repository).save(Mockito.any());
		UserDto user = customUserDetailsService.saveOrUpdate(mockUser());
		assertNotNull(user);
	}
	
	@Test
	public void test_getAllUsers_negativeSecnario() {
		doReturn(Collections.EMPTY_LIST).when(repository).findAll();
		List<UserDto> users =customUserDetailsService.getAllUsers();
		assertEquals(users.size() , Collections.EMPTY_LIST.size());
	}

	private User mockUser() {
		User user = new User();
		user.setEmail("test");
		user.setUser_id(100);
		user.setEmail("test@abc.com");
		user.setRoles(null);
		user.setPassword("test");
		user.setUsername("Anil");
		return user;
	}
}
