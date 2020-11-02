package com.dxc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxc.model.User;
import com.dxc.repository.LoginRepository;


@Service
public class RegistrationService {
	
	@Autowired
	private LoginRepository repo;
	public User saveUser(User user) {
			return repo.save(user);
		}
	public User fetchUserByUsername(String username) {
		return repo.findByUsername(username);
	}
	
	
	public User fetchUserByUsernameAndPassword(String username,String password) {
		return repo.findByUsernameAndPassword(username, password);
	}
}
