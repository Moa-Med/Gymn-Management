package com.sport.gestionmuscu.jpaRepository.controller.rest;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.sport.gestionmuscu.entity.AdminClub;
import com.sport.gestionmuscu.entity.Club;
import com.sport.gestionmuscu.entity.Subscriber;
import com.sport.gestionmuscu.jpaRepository.used.AdminClubJpaRep;
import com.sport.gestionmuscu.jpaRepository.used.ClubJpaRep;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AdminClubRestController {
	
	
	@Autowired
	private AdminClubJpaRep adminClubJpaRep;
	
	@Autowired
	private ClubJpaRep clubJpaRep;
	
	@PutMapping("admin-club/{idAdminClub}/{idClub}")
	public ResponseEntity<AdminClub> updateAdminClub( @PathVariable Long idAdminClub, 
			@PathVariable Long idClub, @RequestBody AdminClub adminClub){
		Optional<AdminClub> adminClubUpdated= adminClubJpaRep.findById(idAdminClub);
		if (adminClubUpdated.isPresent()) {
			adminClub.setClub(clubJpaRep.findById(idClub).get());
			adminClubJpaRep.save(adminClub);
			adminClub.setClub(null);
			return new ResponseEntity<AdminClub>(adminClub, HttpStatus.OK);
		}
		return new ResponseEntity<AdminClub>(adminClub, HttpStatus.NOT_FOUND);
		}

	@GetMapping("login/{login}/{pass}")
	public AdminClub authentification(@PathVariable String login,@PathVariable String pass ) {
		AdminClub adminClub = adminClubJpaRep.findByLoginAdminClubAndPassAdminClub(login, pass);
		if (adminClub!=null) {
			return adminClub;
		}
		return null;
	}
	
	@GetMapping("/admin/{idAdminClub}")
	public List<AdminClub> retreiveListAdmin(@PathVariable Long idAdminClub) {
		List<AdminClub> adminclub=adminClubJpaRep.findAll();
		for (AdminClub adm : adminclub) {
			adm.setClub(null);
		}
		return adminclub;
	}
	
	@GetMapping("/admins/club/{idClub}")
	public List<AdminClub> retreiveListAdminByCLub(@PathVariable Long idClub) {
		Optional<Club> club = clubJpaRep.findById(idClub);
		List<AdminClub> adminclub = new ArrayList<AdminClub>();
		if (club.isPresent()) {
		adminclub=adminClubJpaRep.findByClub(club.get());
		for (AdminClub adm : adminclub) {
			adm.setClub(null);
		}
		}
		return adminclub;
	}
	
	
	@PostMapping("admin-club/{idClub}")
	public ResponseEntity<AdminClub> addAdmin(@PathVariable Long idClub,
			@RequestBody AdminClub adminClub){
		Optional<Club> club=clubJpaRep.findById(idClub);
		if(club.isPresent()) {
			adminClub.setClub(club.get());
		AdminClub addAdminClub=adminClubJpaRep.save(adminClub);
		URI uri=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(addAdminClub.getIdAdminClub()).toUri();
		return ResponseEntity.created(uri).build();
		}
		return null;
		
	}
	
	@GetMapping("admin-detail/{id}")
	public Optional<AdminClub> getAdminClub1(@PathVariable Long id) {
		Optional<AdminClub> adminClub = adminClubJpaRep.findById(id);
		if (adminClub.isPresent()) {			
			return adminClub;
		}
		return null;
	}

	 
	 
	/*@PostMapping("/admin-club")
	public AdminClub addAdminCLub(@RequestBody AdminClub adminClub){
		adminClub.setIdAdminClub(null);
		adminClubJpaRep.save(adminClub);
		return adminClub;
		}*/
	
	
	
}
