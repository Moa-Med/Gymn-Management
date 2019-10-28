package com.sport.gestionmuscu.jpaRepository.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sport.gestionmuscu.entity.SuperAdmin;
import com.sport.gestionmuscu.jpaRepository.used.SuperAdminJpaRep;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class SuperAdminRestController{
	
	@Autowired
	private SuperAdminJpaRep superAdminJpaRep;
	
	@GetMapping("superadmin/{login}/{pass}")
	public SuperAdmin authentification(@PathVariable String login,@PathVariable String pass) {
		SuperAdmin superAdmin = superAdminJpaRep.findByLoginSuperAdminAndPassSuperAdmin(login , pass);
		 if (superAdmin!=null) {
		return superAdmin ;
		     	}
		      	return null;
		        } 
}
