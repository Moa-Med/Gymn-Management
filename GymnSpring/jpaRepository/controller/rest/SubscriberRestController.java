package com.sport.gestionmuscu.jpaRepository.controller.rest;


import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
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
public class SubscriberRestController {
	
	
	@Autowired
	private SubscriberJpaRep subscriberJpaRep;
	
	@Autowired
	private ClubJpaRep clubJpaRep;
	
	
	@GetMapping("/subscribers/{club}")
	public List<Subscriber> retreiveListSubscriber(@PathVariable Long club) {
		List<Subscriber> subscribers=subscriberJpaRep.findByClub(club);
		for (Subscriber sub : subscribers) {
			sub.setClub(null);
		}
		return subscribers;
	}
	
	@GetMapping("/subscriber/{idSubs}")
	public Subscriber retreiveSubscriber(@PathVariable Long idSubs) {
		Subscriber subscriber=subscriberJpaRep.findById(idSubs).get();
		subscriber.setClub(null);
		return subscriber;
	}
	
	@PostMapping("/subscriber/{idClub}")
	public ResponseEntity<Subscriber> addSubscriber(@RequestBody Subscriber subscriber,@PathVariable Long idClub){
		Optional<Club> club=clubJpaRep.findById(idClub);
		if (club.isPresent()) {
			subscriber.setClub(club.get());
			Subscriber addSub = subscriberJpaRep.save(subscriber);
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
					.buildAndExpand(addSub.getidSub()).toUri();
			return ResponseEntity.created(uri).build();
		}
		return null;
	
		}
	
	@DeleteMapping("subscriber/{id}")
	public ResponseEntity<Void> deleteTodo(@PathVariable Long id){
		Optional<Subscriber> subscriber=subscriberJpaRep.findById(id);
		if (subscriber.isPresent()) {
			subscriberJpaRep.deleteById(id);			
			return ResponseEntity.noContent().build();
			
		}
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("subscriber/{idSub}/{idClub}")
	public ResponseEntity<Subscriber> updateSubscriber( @PathVariable Long idSub, 
			@PathVariable Long idClub, @RequestBody Subscriber subscriber){
		Optional<Subscriber> subscriberUpdated= subscriberJpaRep.findById(idSub);
		if (subscriberUpdated.isPresent()) {
			subscriber.setClub(clubJpaRep.findById(idClub).get());
			subscriberJpaRep.save(subscriber);
			subscriber.setClub(null);
			return new ResponseEntity<Subscriber>(subscriber, HttpStatus.OK);
		}
		return new ResponseEntity<Subscriber>(subscriber, HttpStatus.NOT_FOUND);
		}
		
}
