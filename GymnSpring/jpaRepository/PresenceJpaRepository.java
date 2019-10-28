package com.sport.gestionmuscu.jpaRepository;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sport.gestionmuscu.entity.Presence;
import com.sport.gestionmuscu.entity.Subscriber;

@Repository
@Transactional
public class PresenceJpaRepository {

	@Autowired
	EntityManager em;
	
	public Presence addPresence(Subscriber subscriber, Presence presence) {
		subscriber.addPresence(presence);
		presence.setSubscriber(subscriber);
		em.persist(presence);
		em.persist(subscriber);
		return presence;
	}
	
	public List<Presence> allPresence(Subscriber subscriber){
		Query query=em.createNativeQuery("select * from presence where subscriber=:subscriber",
				Presence.class);
		query.setParameter("subscriber", subscriber);
		return (List<Presence>)query.getResultList();
	}
	
	public List<Presence> allPresencePerMonth(Subscriber subscriber, Date date){
		Query query=em.createNativeQuery("select * from presence where subscriber=:subscriber "
				+ "and date_presence like %:date",
				Presence.class);
		query.setParameter("subscriber", subscriber);
		query.setParameter("date", date);		
		return (List<Presence>)query.getResultList();
	}
	
	
}
