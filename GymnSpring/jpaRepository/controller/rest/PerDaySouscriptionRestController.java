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
import com.sport.gestionmuscu.entity.PerDaySubscription;
import com.sport.gestionmuscu.entity.PerYearSubscription;
import com.sport.gestionmuscu.entity.Subscriber;
import com.sport.gestionmuscu.jpaRepository.AdminClubJpaRepository;
import com.sport.gestionmuscu.jpaRepository.used.AdminClubJpaRep;
import com.sport.gestionmuscu.jpaRepository.used.ClubJpaRep;
import com.sport.gestionmuscu.jpaRepository.used.PerDaySouscriptionJpaRep;
import com.sport.gestionmuscu.jpaRepository.used.SubscriberJpaRep;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PerDaySouscriptionRestController {
	
	
	@Autowired
	private PerDaySouscriptionJpaRep PDSJpaRep;
	
	@Autowired
	ClubJpaRep clubJpaRep;
	
	@GetMapping("per-day-subscription/{idClub}")
	public List<PerDaySubscription> getPerDaySubscription(@PathVariable Long idClub) {
		Optional<Club> club=clubJpaRep.findById(idClub);
		if(club.isPresent()) {
			List<PerDaySubscription> resultPerDaySous= PDSJpaRep.findByClub(club.get());
			for (PerDaySubscription result : resultPerDaySous) {
				result.setClub(null);
			}
			return resultPerDaySous;
		}
		return null;
	}
	
	@PostMapping("per-day-subscription/{idClub}")
	public ResponseEntity<PerDaySubscription> addPDS(@PathVariable Long idClub,
			@RequestBody PerDaySubscription perDaySubscription){
		Optional<Club> club=clubJpaRep.findById(idClub);
		if(club.isPresent()) {
		perDaySubscription.setClub(club.get());
		PerDaySubscription perDaySubSaved=PDSJpaRep.save(perDaySubscription);
		URI uri=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(perDaySubSaved.getidTypeSubs()).toUri();
		return ResponseEntity.created(uri).build();
		}
		return null;
		
	}
	
}
