package com.rodrigo.springmongo.resource;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rodrigo.springmongo.domain.User;
import com.rodrigo.springmongo.dto.UserDTO;
import com.rodrigo.springmongo.service.UserService;

@RestController
@RequestMapping(value= "/users")
public class UserResource {
	
	@Autowired
	UserService service;

	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll() {
		List<User> list = service.findAll();
		List<UserDTO> listUserDto = list.stream()
				.map(u -> new UserDTO(u))
				.collect(Collectors.toList());
		return ResponseEntity.ok().body(listUserDto);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable String id) {
		User user = service.findById(id);
		return ResponseEntity.ok().body(new UserDTO(user));
	}
	
}
