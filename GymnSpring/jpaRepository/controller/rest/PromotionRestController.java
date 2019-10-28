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
import com.sport.gestionmuscu.entity.Promotion;
import com.sport.gestionmuscu.entity.Promotion;
import com.sport.gestionmuscu.entity.Subscriber;
import com.sport.gestionmuscu.jpaRepository.AdminClubJpaRepository;
import com.sport.gestionmuscu.jpaRepository.used.AdminClubJpaRep;
import com.sport.gestionmuscu.jpaRepository.used.ClubJpaRep;
import com.sport.gestionmuscu.jpaRepository.used.PerDaySouscriptionJpaRep;
import com.sport.gestionmuscu.jpaRepository.used.PromotionJpaRep;
import com.sport.gestionmuscu.jpaRepository.used.SubscriberJpaRep;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PromotionRestController {
	
	
	@Autowired
	private PromotionJpaRep promotionJpaRep;
	
	@Autowired
	ClubJpaRep clubJpaRep;
	
	
	@PostMapping("promotion/{idClub}")
	public ResponseEntity<Promotion> addPDS(@PathVariable Long idClub,
			@RequestBody Promotion promotion){
		Optional<Club> club=clubJpaRep.findById(idClub);
		if(club.isPresent()) {
			promotion.setClub(club.get());
		Promotion promoSaved=promotionJpaRep.save(promotion);
		URI uri=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(promoSaved.getidTypeSubs()).toUri();
		return ResponseEntity.created(uri).build();
		}
		return null;
		
	}
	
	@GetMapping("promotion/{idClub}")
	public List<Promotion> getPromotion(@PathVariable Long idClub) {
		Optional<Club> club=clubJpaRep.findById(idClub);
		if(club.isPresent()) {
			List<Promotion> resultPromotion= promotionJpaRep.findByClub(club.get());
			for (Promotion result : resultPromotion) {
				result.setClub(null);
			}
			return resultPromotion;
		}
		return null;
	}
	
}
