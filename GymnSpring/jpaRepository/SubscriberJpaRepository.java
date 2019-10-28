package com.sport.gestionmuscu.jpaRepository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sport.gestionmuscu.entity.Club;
import com.sport.gestionmuscu.entity.Subscriber;

@Repository
@Transactional
public class SubscriberJpaRepository {

	@Autowired
	EntityManager em;
	
	public Subscriber save(Subscriber subscriber, Club club) {
		if (subscriber.getidSub()==null)
		{
			subscriber.setClub(club);
			em.persist(subscriber);
		}else {
			em.merge(subscriber);
		}
		return subscriber;
	}
}
