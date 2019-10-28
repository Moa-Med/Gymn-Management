package com.sport.gestionmuscu.jpaRepository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sport.gestionmuscu.entity.Club;
import com.sport.gestionmuscu.entity.ClubSubscription;

@Repository
@Transactional
public class ClubSubscriptionJpaRepository {
	
	@Autowired
	EntityManager em;
	
	public ClubSubscription findById(Long idClubSubscription) {
		return em.find(ClubSubscription.class, idClubSubscription);
	}
	
	public void addClubSubscription(ClubSubscription clubSubscription, Club club) {
		clubSubscription.setClub(club);
		club.addclubSubscription(clubSubscription);
		em.persist(clubSubscription);
	}
}
