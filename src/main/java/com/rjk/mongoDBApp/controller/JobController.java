package com.rjk.mongoDBApp.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rjk.mongoDBApp.model.Post;
import com.rjk.mongoDBApp.repo.JobRepository;
import com.rjk.mongoDBApp.repo.SearchRepository;

import io.swagger.v3.oas.annotations.Hidden;
import jakarta.servlet.http.HttpServletResponse;

@RestController
public class JobController {

	@Autowired
	SearchRepository srepo;
	
	@Autowired
	JobRepository jrepo;
	
	
	@Hidden
	@RequestMapping("/")
	public void redirect(HttpServletResponse httpServlet) {
		try {
			httpServlet.sendRedirect("/swagger-ui/index.html");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@GetMapping("/posts")
	public List<Post> getAllPosts(){
		return jrepo.findAll();
	}
	
	@GetMapping("/posts/{keyword}")
	public List<Post> getPostById(@PathVariable String keyword){
		return srepo.findByText(keyword);
	}
	
	@GetMapping("/post/profile/{profile}")
	public List<Post> findByProfile(@PathVariable String profile){
		return jrepo.findByProfile(profile);
	}
	
	@GetMapping("/post/profiles/{profile}")
	public List<Post> findByProfileLike(@PathVariable String profile){
		return jrepo.findByProfileLike(profile);
	}
	
	@GetMapping("/post/techstack/{techStack}")
	public List<Post> findByTechStackContaining(@PathVariable String techStack){
		return jrepo.findByTechStackContainingIgnoreCase(techStack);
	}
	
	@GetMapping("/post/experience/{start}/{end}")
	public List<Post> findByExperienceBetween(@PathVariable int start,@PathVariable int end){
		return jrepo.findByExperienceBetween(start,end);
	}
	
	@GetMapping("/posts/keyword/{keyword}")
	public List<Post> findByProfileOrDesc(@PathVariable String keyword){
		return jrepo.findByProfileOrDesc(keyword,keyword);
	}
	
	
	@PostMapping("/post")
	public Post createPost(@RequestBody Post post) {
		return jrepo.save(post);
	}
	

}
