package com.sport.gestionmuscu;

import java.util.Date;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sport.gestionmuscu.entity.Activity;
import com.sport.gestionmuscu.entity.AdminClub;
import com.sport.gestionmuscu.entity.Club;
import com.sport.gestionmuscu.entity.ClubSubscription;
import com.sport.gestionmuscu.entity.InfoPaymentClub;
import com.sport.gestionmuscu.entity.PerDaySubscription;
import com.sport.gestionmuscu.entity.PerMonthSubscription;
import com.sport.gestionmuscu.entity.Picture;
import com.sport.gestionmuscu.entity.Presence;
import com.sport.gestionmuscu.entity.Subscriber;
import com.sport.gestionmuscu.entity.Subscription;
import com.sport.gestionmuscu.entity.SubscriptionType;
import com.sport.gestionmuscu.entity.SuperAdmin;
import com.sport.gestionmuscu.entity.TypePayment;
import com.sport.gestionmuscu.jpaRepository.ActivityJpaRepository;
import com.sport.gestionmuscu.jpaRepository.AdminClubJpaRepository;
import com.sport.gestionmuscu.jpaRepository.ClubJpaRepository;
import com.sport.gestionmuscu.jpaRepository.ClubSubscriptionJpaRepository;
import com.sport.gestionmuscu.jpaRepository.InfoPaymentJpaRepository;
import com.sport.gestionmuscu.jpaRepository.PresenceJpaRepository;
import com.sport.gestionmuscu.jpaRepository.SubscriberJpaRepository;
import com.sport.gestionmuscu.jpaRepository.SubscriptionJpaRepository;
import com.sport.gestionmuscu.jpaRepository.SubscriptionTypeJpaRepository;
import com.sport.gestionmuscu.jpaRepository.SuperAdminRepository;
import com.sport.gestionmuscu.jpaRepository.TypePaymentJpaRepository;


@SpringBootApplication
public class GesMuscuApplication implements CommandLineRunner{
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ClubJpaRepository clubJpaRepository;
	
	@Autowired
	private AdminClubJpaRepository adminClubJpaRepository;
	
	@Autowired
	ActivityJpaRepository activityJpaRepository;
	
	@Autowired
	InfoPaymentJpaRepository infoPaymentJpaRepository;
	
	@Autowired
	TypePaymentJpaRepository typePaymentJpaRepository;
	
	@Autowired
	SubscriberJpaRepository subscriberJpaRepository;
	
	@Autowired
	PresenceJpaRepository presenceJpaRepository;
	
	@Autowired
	SubscriptionJpaRepository subscriptionJpaRepository;
	
	@Autowired
	SuperAdminRepository superAdminJpaRepository;
	
	@Autowired
	ClubSubscriptionJpaRepository clubSubscriptionJpaRepository;
	
	@Autowired
	SubscriptionTypeJpaRepository subscriptionTypeJpaRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(GesMuscuApplication.class, args);
	   }
	@Override
	@Transactional
	public void run(String... args) throws Exception {
		  
		    
		   
		Club club=clubJpaRepository.save(new Club("CL01","new man club","maarif","good"));
		adminClubJpaRepository.addAdminClub(new AdminClub("aba", "ekhizi","casa","1245",new Date(),"abay", "1234"), club);
	//	adminClubJpaRepository.addAdminClub(new AdminClub("moh", "moh", "moh", "1234"), club);
		adminClubJpaRepository.addAdminClub(new AdminClub("mo", "Traore","casa","1245",new Date(),"moh", "1234"), club);

		
		Subscriber subscriber = subscriberJpaRepository.save(new Subscriber("mohamed","amar",new Date(),30,75,183,"M"), club);
		Subscriber subscriber1 = subscriberJpaRepository.save(new Subscriber("majdaoui","moh",new Date(),30,75,183,"M"), club); 
		
		SuperAdmin superAdmin=superAdminJpaRepository.save(new SuperAdmin("Mohamed","Traore","moh","123"));
		SuperAdmin superAdmin1=superAdminJpaRepository.save(new SuperAdmin("Abay","Ekhizi","abay","123"));

	}

}
