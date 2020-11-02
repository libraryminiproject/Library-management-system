package com.dxc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;




import com.dxc.model.User;

public interface RegisterRepository extends JpaRepository<User, Integer> {
	
	  

}
