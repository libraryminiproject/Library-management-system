package com.dxc.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dxc.model.Admin;


public interface AdminRepository extends JpaRepository<Admin, String> {
	public Admin findByEmail(String email);
	public Admin findByEmailAndPassword(String email,String password);

	public Optional<Admin> findById(int Id);

}