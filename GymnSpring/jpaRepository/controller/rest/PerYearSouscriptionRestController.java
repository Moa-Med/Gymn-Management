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
import com.sport.gestionmuscu.entity.PerYearSubscription;
import com.sport.gestionmuscu.entity.PerYearSubscription;
import com.sport.gestionmuscu.entity.Subscriber;
import com.sport.gestionmuscu.jpaRepository.AdminClubJpaRepository;
import com.sport.gestionmuscu.jpaRepository.used.AdminClubJpaRep;
import com.sport.gestionmuscu.jpaRepository.used.ClubJpaRep;
import com.sport.gestionmuscu.jpaRepository.used.PerDaySouscriptionJpaRep;
import com.sport.gestionmuscu.jpaRepository.used.PerYearSouscriptionJpaRep;
import com.sport.gestionmuscu.jpaRepository.used.SubscriberJpaRep;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PerYearSouscriptionRestController {
	
	
	@Autowired
	private PerYearSouscriptionJpaRep PYSJpaRep;
	
	@Autowired
	ClubJpaRep clubJpaRep;
	
	
	@PostMapping("per-year-subscription/{idClub}")
	public ResponseEntity<PerYearSubscription> addPYSubscription(@PathVariable Long idClub,
			@RequestBody PerYearSubscription perYearSubscription){
		Optional<Club> club=clubJpaRep.findById(idClub);
		if(club.isPresent()) {
			perYearSubscription.setClub(club.get());
		PerYearSubscription perYearSubscriptionSaved=PYSJpaRep.save(perYearSubscription);
		URI uri=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(perYearSubscriptionSaved.getidTypeSubs()).toUri();
		return ResponseEntity.created(uri).build();
		}
		return null;
		
	}
	
	@GetMapping("per-year-subscription/{idClub}")
	public List<PerYearSubscription> getPerYearSubscription(@PathVariable Long idClub) {
		Optional<Club> club=clubJpaRep.findById(idClub);
		if(club.isPresent()) {
			List<PerYearSubscription> resultPerYearSous= PYSJpaRep.findByClub(club.get());
			for (PerYearSubscription result : resultPerYearSous) {
				result.setClub(null);
			}
			return resultPerYearSous;
		}
		return null;
	}
	
}
