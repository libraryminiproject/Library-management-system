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

import com.dxc.model.Author;
import com.dxc.repository.AuthorRepository;





@RestController @CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/api")
public class AuthorController {

	@Autowired
	 private AuthorRepository authorRepository;
	
	
	@GetMapping("/author")
	public List<Author> getAllauthor()
	{
				 return (List<Author>)authorRepository.findAll();
	}
	
	
	
	@GetMapping("/author/{id}")
	public ResponseEntity<Author> getAuthorById(@PathVariable(value = "id") int authorId)
	        throws ResourceNotFoundException {
	        Author author = authorRepository.findById(authorId)
	          .orElseThrow(() -> new ResourceNotFoundException("author not found for this id :: " + authorId));
	        return ResponseEntity.ok().body(author);
	         }
	
	
	@PostMapping("/author")
	public Author createbook ( @RequestBody Author author)
	{
		return authorRepository.save(author);
	}
	
	
	
	
	
	}
