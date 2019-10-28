package com.sport.gestionmuscu.jpaRepository;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sport.gestionmuscu.entity.AdminClub;
import com.sport.gestionmuscu.entity.Subscriber;
import com.sport.gestionmuscu.entity.Subscription;
import com.sport.gestionmuscu.entity.SubscriptionType;

@Repository
@Transactional
public class SubscriptionJpaRepository {
	
	@Autowired
	EntityManager em;
	
	
	
	public void addSubscription(Subscription subscription,SubscriptionType subscriptionType, Subscriber subscriber, AdminClub logger){
		//enregistrement de la subscription
		subscriber.addSubscription(subscription);
		subscription.setSubscriber(subscriber);
		subscription.setLogger(logger);		
		logger.addSubscription(subscription);
		subscription.setSubscriptionType(subscriptionType);
		subscriptionType.addSubscription(subscription);
		em.merge(subscription);		
	}
	

}
