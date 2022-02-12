package com.projectcomment.projectcomment.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.projectcomment.projectcomment.Entity.CommentEntity;
import com.projectcomment.projectcomment.Entity.LoginEntity;
import com.projectcomment.projectcomment.Repositoy.CommentRepository;
import com.projectcomment.projectcomment.Repositoy.LoginRepository;
import com.projectcomment.projectcomment.model.Response;
@RestController
@CrossOrigin
@RequestMapping("/comment")
public class CommentController {

	 @Autowired
	 CommentRepository commentRepository;
	 
	@PostMapping("/add")
	public Response addUSer(@RequestBody CommentEntity addObj) {
		commentRepository.save(addObj);
		return new Response("OK","Comment saved successfully!!");
		
	}
	
	@GetMapping("/get/{emailId}")
	public Response getUSer(@PathVariable String emailId) {
		
		List<CommentEntity> lis = commentRepository.findByEmailId(emailId);
		if(lis.size() > 0) {
			return new Response("OK","Comments available for user",lis);
		}
		return new Response("Not OK","Comments not available for user");
		
	}
	
	@GetMapping("/getAllComments")
	public Response getAllComments() {
		List<CommentEntity> lis = commentRepository.findAll();
		if(lis.size() > 0) {
			return new Response("OK","Comments available",lis);
		}
		return new Response("Not OK","Comments not available");
	}
	
	@GetMapping("/getPassword/{emailId}")
	public List<CommentEntity> getPassword(@PathVariable String emailId) {
		List<CommentEntity> lis = commentRepository.findByEmailId(emailId);
		return lis;
	}
}



