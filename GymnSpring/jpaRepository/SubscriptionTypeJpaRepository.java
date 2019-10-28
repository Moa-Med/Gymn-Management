package com.sport.gestionmuscu.jpaRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sport.gestionmuscu.entity.Club;
import com.sport.gestionmuscu.entity.SubscriptionType;

@Repository
@Transactional
public class SubscriptionTypeJpaRepository {

	@Autowired
	EntityManager em;
	
	public SubscriptionType addSubscriptionType(SubscriptionType subscriptionType, Club club) {
		subscriptionType.setClub(club);
		club.addsubscriptionType(subscriptionType);
		em.persist(subscriptionType);
		return subscriptionType;
		}
	public List<SubscriptionType> getAllSubsType(Club club){
		Query query= em.createNamedQuery("select * from SubscriptionType where club=:club", SubscriptionType.class);
		query.setParameter("club", club.getidClub());
		return query.getResultList();		
	}
	
	
}
