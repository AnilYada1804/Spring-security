package com.spring.security.api.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.spring.security.api.dto.UserDto;
import com.spring.security.api.model.User;
import com.spring.security.api.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository repository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = repository.findByUsername(username);
		CustomUserDetails userDetails = null;
		if (Objects.nonNull(user)) {
			userDetails = new CustomUserDetails();
			userDetails.setUser(user);
		} else {
			throw new UsernameNotFoundException("User not exist with name : " + username);
		}
		return userDetails;

	}

	public List<UserDto> getAllUsers() {
		List<UserDto> userDtos = new ArrayList<UserDto>();
		try {
			List<User> users = repository.findAll();
			if (!CollectionUtils.isEmpty(users)) {
				userDtos = users.stream().map(s -> new UserDto(s)).sorted(Comparator.comparing(UserDto::getUser_id))
						.collect(Collectors.toList());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userDtos;
	}

	@Transactional
	public UserDto saveOrUpdate(User user) {
		try {
			if (!StringUtils.isEmpty(user.getPassword())) {
				String pwd = user.getPassword();
				String encryptPwd = passwordEncoder.encode(pwd);
				user.setPassword(encryptPwd);
			}
			user = repository.save(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new UserDto(user);
	}

	public Optional<User> findById(Integer id) {
		Optional<User> user = repository.findById(id);
		return user;
	}
	
	@Transactional
	public void deleteUserById(Integer id) {
		 repository.deleteById(id);
	}

}
