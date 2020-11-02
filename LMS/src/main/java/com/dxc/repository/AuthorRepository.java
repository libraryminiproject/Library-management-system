package com.dxc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dxc.model.Author;





public interface AuthorRepository extends JpaRepository<Author, Integer> {
	
	  

}
