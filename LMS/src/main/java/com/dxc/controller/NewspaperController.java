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

import com.dxc.model.Newspaper;
import com.dxc.repository.NewspapersRepository;





@RestController @CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/api")
public class NewspaperController {

	@Autowired
	 private NewspapersRepository newspapersRepository;
	
	
	@GetMapping("/newspaper")
	public List<Newspaper> getAllnewspaper()
	{
				 return (List<Newspaper>) newspapersRepository.findAll();
	}
	
	@GetMapping("/newspaper/{name}")
	public ResponseEntity<Newspaper> getNewspaperByName(@PathVariable(value = "name") String newspapername)
	        throws ResourceNotFoundException {
	        Newspaper newspaper = newspapersRepository.findByName(newspapername)
	          .orElseThrow(() -> new ResourceNotFoundException("newspaper not found for this name :: " + newspapername));
	        return ResponseEntity.ok().body(newspaper);
	    }
	@PostMapping("/newspaper")
	public Newspaper createnewspaper( @RequestBody Newspaper newspaper)
	{
		return newspapersRepository.save(newspaper);
	}
	
	@PutMapping("/newspaper/{name}")
	 public ResponseEntity<Newspaper> updatenewspaper(@PathVariable(value = "name") String newspapername,
	          @RequestBody Newspaper newspaperDetails) throws ResourceNotFoundException {
	        Newspaper newspaper = newspapersRepository.findByName(newspapername)
	        .orElseThrow(() -> new ResourceNotFoundException("newspaper not found for this name :: " + newspapername));

	        
	        newspaper.setName(newspaperDetails.getName());
	       newspaper.setDob(newspaperDetails.getDob());
	       newspaper.setPages(newspaperDetails.getPages());
	       newspaper.setPrice(newspaperDetails.getPrice());
	       newspaper.setLanguage(newspaperDetails.getLanguage());
	       
	        
	        final Newspaper updatednewspaper = newspapersRepository.save(newspaper);
	        return ResponseEntity.ok(updatednewspaper);
	    }

	
	@DeleteMapping(  "/newspaper/{name}")
	public Map<String, Boolean> deletenewspaper(@PathVariable(value = "name") String newspapername)
	         throws ResourceNotFoundException {
	       Newspaper newspaper = newspapersRepository.findByName(newspapername)
	       .orElseThrow(() -> new ResourceNotFoundException("newspaper not found for this name :: " + newspapername));

	      newspapersRepository.delete(newspaper);
	        Map<String, Boolean> response = new HashMap<>();
	        response.put("deleted", Boolean.TRUE);
	        return response;
	    }
	}
