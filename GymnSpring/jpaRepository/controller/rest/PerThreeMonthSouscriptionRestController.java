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
import com.sport.gestionmuscu.entity.PerMonthSubscription;
import com.sport.gestionmuscu.entity.PerThreeMonthSubscription;
import com.sport.gestionmuscu.entity.PerThreeMonthSubscription;
import com.sport.gestionmuscu.entity.PerYearSubscription;
import com.sport.gestionmuscu.entity.Subscriber;
import com.sport.gestionmuscu.jpaRepository.AdminClubJpaRepository;
import com.sport.gestionmuscu.jpaRepository.used.AdminClubJpaRep;
import com.sport.gestionmuscu.jpaRepository.used.ClubJpaRep;
import com.sport.gestionmuscu.jpaRepository.used.PerDaySouscriptionJpaRep;
import com.sport.gestionmuscu.jpaRepository.used.PerMonthSouscriptionJpaRep;
import com.sport.gestionmuscu.jpaRepository.used.PerThreeMonthSouscriptionJpaRep;
import com.sport.gestionmuscu.jpaRepository.used.SubscriberJpaRep;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PerThreeMonthSouscriptionRestController {
	
	
	@Autowired
	private PerThreeMonthSouscriptionJpaRep PTMSJpaRep;
	
	@Autowired
	ClubJpaRep clubJpaRep;
	
	
	@PostMapping("per-three-month-subscription/{idClub}")
	public ResponseEntity<PerThreeMonthSubscription> addPMSsubscription(@PathVariable Long idClub,
			@RequestBody PerThreeMonthSubscription perThreeMonthSubscription){
		Optional<Club> club=clubJpaRep.findById(idClub);
		if(club.isPresent()) {
			perThreeMonthSubscription.setClub(club.get());
			PerThreeMonthSubscription perThreeMonthSubscriptionsaved=PTMSJpaRep.save(perThreeMonthSubscription);
		URI uri=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(perThreeMonthSubscriptionsaved.getidTypeSubs()).toUri();
		return ResponseEntity.created(uri).build();
		}
		return null;
		
	}
	
	@GetMapping("per-three-month-subscription/{idClub}")
	public List<PerThreeMonthSubscription> getPerThreeMonthSubscription(@PathVariable Long idClub) {
		Optional<Club> club=clubJpaRep.findById(idClub);
		if(club.isPresent()) {
			List<PerThreeMonthSubscription> resultPerThreeMonthSous= PTMSJpaRep.findByClub(club.get());
			for (PerThreeMonthSubscription result : resultPerThreeMonthSous) {
				result.setClub(null);
			}
			return resultPerThreeMonthSous;
		}
		return null;
	}
	
}
