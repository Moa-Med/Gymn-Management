package com.sport.gestionmuscu.jpaRepository.controller.rest;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.sport.gestionmuscu.entity.AdminClub;
import com.sport.gestionmuscu.entity.Club;
import com.sport.gestionmuscu.entity.Subscriber;
import com.sport.gestionmuscu.jpaRepository.AdminClubJpaRepository;
import com.sport.gestionmuscu.jpaRepository.used.AdminClubJpaRep;
import com.sport.gestionmuscu.jpaRepository.used.ClubJpaRep;
import com.sport.gestionmuscu.jpaRepository.used.SubscriberJpaRep;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ClubRestController {
	
	
	@Autowired
	private ClubJpaRep clubJpaRep;
	
	
	@GetMapping("login/club/{login}/{pass}")
	public Club authentification(@PathVariable String login,@PathVariable String pass ) {
		Club club = clubJpaRep.findClubByLoginAndPassword(login, pass);
		if (club!=null) {
			club.addActivity(null);
			club.setAdminClub(null);
			club.setClubSubscription(null);
			club.setInfoPaymentClubs(null);
			club.setSubscribers(null);
			club.setSubscriptionType(null);
			return club;
		}
		return null;
	}
	
	@GetMapping("club")
	public List<Club> retriveClub() {
		List<Club> clubs = clubJpaRep.findAll();
		if (clubs!=null) {
			return clubs;
		}
		return null;
	}
	
	@PostMapping("/club")
	public ResponseEntity<Club> addClub(@RequestBody Club club){
			Club clubsaved = clubJpaRep.save(club);
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
					.buildAndExpand(clubsaved.getidClub()).toUri();
			return ResponseEntity.created(uri).build();
		}
	
	@GetMapping("/admin-club/{id}")
	public Club findClub(@PathVariable Long id) {
		Optional<Club> club = clubJpaRep.findClubByIdAdminClub(id);
		if (club.isPresent()) {
			club.get().addActivity(null);
			club.get().setAdminClub(null);
			club.get().setClubSubscription(null);
			club.get().setInfoPaymentClubs(null);
			club.get().setSubscribers(null);
			club.get().setSubscriptionType(null);
			return club.get();
		}
		return null;
	}
	
}
