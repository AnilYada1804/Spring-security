package com.spring.security.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.security.api.dto.UserDto;
import com.spring.security.api.model.User;
import com.spring.security.api.service.CustomUserDetailsService;

@RestController
@RequestMapping("/api/auth/")
public class AdminController {

	@Autowired
	private CustomUserDetailsService userSerice;

	/**
	 * Add new user
	 * 
	 * @param user
	 * @return
	 */
	@PostMapping("/add")
	public ResponseEntity<UserDto> addUserByAdmin(@RequestBody User user) {
		return new ResponseEntity<UserDto>(userSerice.saveOrUpdate(user), HttpStatus.OK);
	}

	/**
	 * Get All Users
	 * 
	 * @return
	 */
	@GetMapping("/user/getAllUsers")
	public ResponseEntity<List<UserDto>> getAllUsers() {
		return new ResponseEntity<List<UserDto>>(userSerice.getAllUsers(), HttpStatus.OK);
	}

	/**
	 * Get User by Id
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/user/{id}")
	public ResponseEntity<UserDto> getUserById(@PathVariable int id) {
		Optional<User> optionalUser = userSerice.findById(id);
		if (!optionalUser.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return new ResponseEntity<UserDto>(new UserDto(optionalUser.get()), HttpStatus.OK);
	}
	//pathVariable
	//http://localhost:8080/users/id/4
	//pathvariable extract the data right from from UI
	//pathVariable is more useful for Restfull webservcies
	@GetMapping(value ="/users/{id}")
	public ResponseEntity<?> getAllLdapUsers(@PathVariable String id){
		return new ResponseEntity<String>("Ok", HttpStatus.OK);
	}
	
	//@RequestParam
	//http://localhost:8080/users?id=4
	//RequestParam is used to extract data from query parameters
	//RequestParam is more useful on a traditional Weba application where data is mostly passed in query parameters
	@GetMapping(value ="/users")
	public ResponseEntity<?> getAllLdapUsersTest(@RequestParam String id){
		return new ResponseEntity<String>("Ok", HttpStatus.OK);
	}

	/**
	 * Update User by userID PUT method
	 * 
	 * @param id
	 * @param dto
	 * @return
	 */
	@PutMapping(value = "/edit/{id}")
	public ResponseEntity<UserDto> updateUser(@PathVariable int id, @RequestBody UserDto dto) {
		Optional<User> optionalUser = userSerice.findById(id);
		if (!optionalUser.isPresent()) {
			System.out.println("User with id " + id + " does not exist");
			return ResponseEntity.notFound().build();
		}
		User user = optionalUser.get();
		user.setUser_id(dto.getUser_id());
		user.setEmail(dto.getEmail());
		user.setUsername(dto.getUsername());
		user.setRoles(dto.getRoles());
		return new ResponseEntity<UserDto>(userSerice.saveOrUpdate(user), HttpStatus.OK);
	}

	/**
	 * Delete user by userID
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable int id) {
		Optional<User> optionalUser = userSerice.findById(id);
		if (!optionalUser.isPresent()) {
			System.out.println("User with id " + id + " does not exist");
			return ResponseEntity.notFound().build();
		}
		userSerice.deleteUserById(id);
		return ResponseEntity.ok().build();
	}

}
