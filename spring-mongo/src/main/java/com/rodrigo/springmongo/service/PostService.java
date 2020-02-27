package com.rodrigo.springmongo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rodrigo.springmongo.domain.Post;
import com.rodrigo.springmongo.exception.ObjectNotFoundException;
import com.rodrigo.springmongo.repository.PostRepository;

@Service
public class PostService {

	@Autowired
	PostRepository postRepository;
	
	public Post findById(String id) {
		Optional<Post> postUser = postRepository.findById(id);
		return postUser.orElseThrow(() -> new ObjectNotFoundException("Usuário sem post criado!"));
	}
	
	public List<Post> findAll() {
		return postRepository.findAll();
	}
	
	public List<Post> findByTitle(String text) {
		return postRepository.findByTitleContainingIgnoreCase(text);
	}
}
