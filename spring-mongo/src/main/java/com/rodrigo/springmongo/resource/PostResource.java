package com.rodrigo.springmongo.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rodrigo.springmongo.domain.Post;
import com.rodrigo.springmongo.service.PostService;

@RestController
@RequestMapping("/posts")
public class PostResource {
	
	@Autowired
	PostService service;
	
	@GetMapping()
	public ResponseEntity<List<Post>> findAll() {
		return ResponseEntity.ok().body(service.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Post> findById(@PathVariable String id) {
		Post post = service.findById(id);
		return ResponseEntity.ok().body(post);
	}
	
	

}
