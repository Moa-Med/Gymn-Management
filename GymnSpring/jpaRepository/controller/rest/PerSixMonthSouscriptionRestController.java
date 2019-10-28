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
import com.sport.gestionmuscu.entity.PerSixMonthSubscription;
import com.sport.gestionmuscu.entity.PerYearSubscription;
import com.sport.gestionmuscu.entity.Subscriber;
import com.sport.gestionmuscu.jpaRepository.AdminClubJpaRepository;
import com.sport.gestionmuscu.jpaRepository.used.AdminClubJpaRep;
import com.sport.gestionmuscu.jpaRepository.used.ClubJpaRep;
import com.sport.gestionmuscu.jpaRepository.used.PerDaySouscriptionJpaRep;
import com.sport.gestionmuscu.jpaRepository.used.PerMonthSouscriptionJpaRep;
import com.sport.gestionmuscu.jpaRepository.used.PerSixMonthSouscriptionJpaRep;
import com.sport.gestionmuscu.jpaRepository.used.SubscriberJpaRep;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PerSixMonthSouscriptionRestController {
	
	
	@Autowired
	private PerSixMonthSouscriptionJpaRep PSMSJpaRep;
	
	@Autowired
	ClubJpaRep clubJpaRep;
	
	
	@PostMapping("per-six-month-subscription/{idClub}")
	public ResponseEntity<PerSixMonthSubscription> addPSMSsubscription(@PathVariable Long idClub,
			@RequestBody PerSixMonthSubscription perSixMonthSubscription){
		Optional<Club> club=clubJpaRep.findById(idClub);
		if(club.isPresent()) {
			perSixMonthSubscription.setClub(club.get());
			PerSixMonthSubscription perSixMonthSubscriptionsaved=PSMSJpaRep.save(perSixMonthSubscription);
		URI uri=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(perSixMonthSubscriptionsaved.getidTypeSubs()).toUri();
		return ResponseEntity.created(uri).build();
		}
		return null;
		
	}
	
	@GetMapping("per-six-month-subscription/{idClub}")
	public List<PerSixMonthSubscription> getPerSixMonthSubscription(@PathVariable Long idClub) {
		Optional<Club> club=clubJpaRep.findById(idClub);
		if(club.isPresent()) {
			List<PerSixMonthSubscription> resultPerSixMonthSous= PSMSJpaRep.findByClub(club.get());
			for (PerSixMonthSubscription result : resultPerSixMonthSous) {
				result.setClub(null);
			}
			return resultPerSixMonthSous;
		}
		return null;
	}
	
}
