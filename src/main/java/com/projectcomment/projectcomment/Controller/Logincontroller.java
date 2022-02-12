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
import com.projectcomment.projectcomment.Entity.LoginEntity;
import com.projectcomment.projectcomment.Repositoy.LoginRepository;
import com.projectcomment.projectcomment.model.Response;
@RestController
@CrossOrigin
@RequestMapping("/login")
public class Logincontroller {
	 @Autowired
	 LoginRepository loginRepository;
	 
	@PostMapping("/add")
	public Response addUSer(@RequestBody LoginEntity addObj) {
		System.out.println(addObj.getEmailId()+addObj.getEmailId());
		List<?> list = loginRepository.findByEmailId(addObj.getEmailId());
		if(list.size() > 0) {
			return  new Response("NOT OK", "User already exists!!");
		}
		loginRepository.save(addObj);
		return  new Response("OK", "User Added Successfully!!");
	}
	
	@GetMapping("/get/{emailId}")
	public List<LoginEntity> getUser(@PathVariable String emailId) {
		//System.out.println(addObj.getEmailId()+addObj.getEmailId());
		List<LoginEntity> lis = loginRepository.findByEmailId(emailId);
		return lis;
	}
	@GetMapping("/authenticate/{emailId}/{password}")
	public Response authenticate(@PathVariable("emailId") String emailId, @PathVariable("password") String password) {
		List<LoginEntity> lis = loginRepository.findByEmailIdAndPassword(emailId,password);
		if(lis.size() > 0 ) {
			 return new Response("OK", "User Is Authenticated", lis);
		}
		return new Response("NOT OK", "User Is UnAuthenticated",lis);
		
		
	}
	
	@GetMapping("/getAllUsers")
	public Response getAllUSer() {
		//System.out.println(addObj.getEmailId()+addObj.getEmailId());
		List<LoginEntity> lis = loginRepository.findAll();
		if(lis.size() <= 0) {
			return new Response("NOT OK", "No Users found");
		}
		return new Response("OK", "Users found", lis);
	}
	
	@GetMapping("/getPassword/{emailId}/{secreteCode}")
	public Response getPassword(@PathVariable("emailId") String emailId ,@PathVariable("secreteCode") String secreteCode ) {
		//System.out.println(addObj.getEmailId()+addObj.getEmailId());
		List<LoginEntity> lis = loginRepository.findByEmailIdAndSecreteCode(emailId,secreteCode);
		if(lis.size() <= 0) {
			return new Response("NOT OK", "No password available for email and secrete code");
		}
		return new Response("OK", "Password available", lis);
	}
	
	

}
