package com.rodrigo.springmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.rodrigo.springmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}