package com.spring.security.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.test.util.ReflectionTestUtils;

import com.spring.security.api.model.User;
import com.spring.security.api.service.CustomUserDetails;

@RunWith(MockitoJUnitRunner.class)
public class CustomUserDetailsTest {

	CustomUserDetails customUserDetails;

	@Mock
	private User user;

	@Before
	public void setUp() {
		customUserDetails = new CustomUserDetails();
		ReflectionTestUtils.setField(customUserDetails, "user", user);
	}

	@Test
	public void test_getPassword() {
		String expected = customUserDetails.getPassword();
		assertNull(expected);
	}

	@Test
	public void test_userName() {
		String expected = customUserDetails.getUsername();
		assertNull(expected);
	}

	@Test
	public void test_isAccountNotExpired() {
		boolean expected = customUserDetails.isAccountNonExpired();
		assertTrue(expected);
	}

	@Test
	public void test_isCredentialsNonExpired() {
		boolean expected = customUserDetails.isCredentialsNonExpired();
		assertTrue(expected);
	}

	@Test
	public void test_isEnabled() {
		boolean expected = customUserDetails.isEnabled();
		assertTrue(expected);
	}

	@Test
	public void test_isAccountNonLocked() {
		boolean expected = customUserDetails.isAccountNonLocked();
		assertTrue(expected);
	}

	@SuppressWarnings("unchecked")
	@Test
	public void test_getAuthorities() {
		List<SimpleGrantedAuthority> expected = (List<SimpleGrantedAuthority>) customUserDetails.getAuthorities();
		assertEquals(expected.size(), 0);
	}

}
