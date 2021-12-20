package com.spring.security.api.dto;

import java.util.Set;

import org.springframework.stereotype.Component;

import com.spring.security.api.model.Role;
import com.spring.security.api.model.User;

@Component
public class UserDto {

	private int user_id;
	private String username;
	private String email;
	private Set<Role> roles;

	public UserDto(User user) {
		this.user_id = user.getUser_id();
		this.email = user.getEmail();
		this.username = user.getUsername();
		this.roles = user.getRoles();
	}

	public UserDto() {
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

}
