package com.dxc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dxc.model.IssuedBook;

public interface IssuedBookRepository extends JpaRepository<IssuedBook, Integer> {
	
	  

}
