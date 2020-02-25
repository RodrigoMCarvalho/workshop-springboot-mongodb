package com.rodrigo.springmongo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rodrigo.springmongo.domain.User;
import com.rodrigo.springmongo.dto.UserDTO;
import com.rodrigo.springmongo.exception.ObjectNotFoundException;
import com.rodrigo.springmongo.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository repo;
	
	public List<User> findAll() {
		return repo.findAll();
	}
	
	public User findById(String id) {
		Optional<User> user = repo.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoundException("Usuário não localizado."));
	}
	
	public User insert(User user) {
		return repo.insert(user);
	}
	
	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}
	
	public User update(User user) {
		User novoUser = findById(user.getId());
		updateData(novoUser, user);
		return repo.save(novoUser);
	}
	
	private void updateData(User novoUser, User user) {
		novoUser.setName(user.getName());
		novoUser.setEmail(user.getEmail());
	}

	public User fromDTO(UserDTO userDTO) {
		return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
