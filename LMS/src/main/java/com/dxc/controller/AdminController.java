package com.dxc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dxc.model.Admin;
import com.dxc.service.AdminService;




@RestController @CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/api")
public class AdminController {
	@Autowired
	private AdminService service;
	
	@PostMapping("/admin")
	   public Admin AdminUser(@RequestBody Admin admin) throws Exception {
		  String tempEmail = admin.getEmail();
		   String tempPass = admin.getPassword();
	       Admin adminObj = null; 
				   if(tempEmail != null && tempPass != null) {
				
				adminObj = service.fetchAdminByEmailAndPassword(tempEmail, tempPass);
				   }
				   if(adminObj == null) {
					   throw new Exception("bad credentials");
				   }
		   return adminObj;
		   
		  
	   }

}
