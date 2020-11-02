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

import com.dxc.model.Books;
import com.dxc.model.IssuedBook;
import com.dxc.model.Magazines;
import com.dxc.repository.IssuedBookRepository;



@RestController @CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/api")
public class IssuedBookController {

	@Autowired
	 private IssuedBookRepository issuedbookRepository;
	
	
	@GetMapping("/issued_book")
	public List<IssuedBook> getAllissued_book()
	{
				 return (List<IssuedBook>) issuedbookRepository.findAll();
	}
	
	@GetMapping("/issued_book/{id}")
	public ResponseEntity<IssuedBook> getIssuedBookById(@PathVariable(value = "id") int issued_bookId)
	        throws ResourceNotFoundException {
	        IssuedBook issued_book = issuedbookRepository.findById(issued_bookId)
	          .orElseThrow(() -> new ResourceNotFoundException("issuedbook not found for this id :: " + issued_bookId));
	        return ResponseEntity.ok().body(issued_book);
	    }
	@PostMapping("/issued_book")
	public IssuedBook createissued_book ( @RequestBody IssuedBook issued_book)
	{
		return issuedbookRepository.save(issued_book);
	}
	
	
	@PutMapping("/issued_book/{id}")
	 public ResponseEntity<IssuedBook> updateissued_book(@PathVariable(value = "id") int issued_bookId,
	          @RequestBody IssuedBook issued_bookDetails) throws ResourceNotFoundException {
	        IssuedBook issued_book = issuedbookRepository.findById(issued_bookId)
	        .orElseThrow(() -> new ResourceNotFoundException("issuedbook not found for this id :: " + issued_bookId));

	        issued_book.setUser_id(issued_bookDetails.getUser_id());
	        issued_book.setBook_number(issued_bookDetails.getBook_number());
	       issued_book.setBook_title(issued_bookDetails.getBook_title());
	       issued_book.setBook_author(issued_bookDetails.getBook_author());
	      issued_book.setIssueddob(issued_bookDetails.getIssueddob());
	      issued_book.setUsername(issued_bookDetails.getUsername());
	       
	        
	        
	        final IssuedBook updatedissued_book = issuedbookRepository.save(issued_book);
	        return ResponseEntity.ok(updatedissued_book);
	    }
	@DeleteMapping(  "/issued_book/{id}")
	public Map<String, Boolean> deleteissued_book(@PathVariable(value = "id") int issued_bookId)
	         throws ResourceNotFoundException {
	        IssuedBook issued_book = issuedbookRepository.findById(issued_bookId)
	       .orElseThrow(() -> new ResourceNotFoundException("issuedbook not found for this id :: " + issued_bookId));

	      issuedbookRepository.delete(issued_book);
	        Map<String, Boolean> response = new HashMap<>();
	        response.put("deleted", Boolean.TRUE);
	        return response;
	    }
	
	
	}
