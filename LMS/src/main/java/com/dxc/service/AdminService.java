package com.dxc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxc.model.Admin;
import com.dxc.repository.AdminRepository;




@Service
public class AdminService {
	
	@Autowired
	private AdminRepository repo;
	public Admin saveAdmin(Admin admin) {
			return repo.save(admin);
		}
	
	public Admin fetchAdminByEmail(String email) {
		return repo.findByEmail(email);
	}
	
	
	public Admin fetchAdminByEmailAndPassword(String email,String password) {
		return repo.findByEmailAndPassword(email, password);
	}
}
