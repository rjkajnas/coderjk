package com.rjk.mongoDBApp.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.rjk.mongoDBApp.model.Post;

public interface JobRepository extends MongoRepository<Post,String>{

	List<Post> findByProfile(String profile);
	List<Post> findByProfileLike(String profile);
	List<Post> findByTechStackContainingIgnoreCase(String techStack);
	List<Post> findByExperienceBetween(int start, int end);
	List<Post> findByProfileOrDesc(String profile,String desc);
	
}
