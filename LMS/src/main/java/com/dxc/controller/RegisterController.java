package com.dxc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dxc.model.User;
import com.dxc.repository.RegisterRepository;







@RestController @CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/api")
public class RegisterController {

	@Autowired
	 private RegisterRepository registerRepository;
	
	
	@GetMapping("/user")
	public List<User> getAlluser()
	{
				 return (List<User>) registerRepository.findAll();
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<User> getUserById(@PathVariable(value = "id") int userId)
	        throws ResourceNotFoundException {
	        User user = registerRepository.findById(userId)
	          .orElseThrow(() -> new ResourceNotFoundException("user not found for this id :: " + userId));
	        return ResponseEntity.ok().body(user);
	    }
	@PostMapping("/user")
	public User createuser ( @RequestBody User user)
	{
		return registerRepository.save(user);
	}
	
	
	}
