package com.sport.gestionmuscu.jpaRepository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sport.gestionmuscu.entity.Club;
import com.sport.gestionmuscu.entity.InfoPaymentClub;
import com.sport.gestionmuscu.entity.TypePayment;

@Repository
@Transactional
public class InfoPaymentJpaRepository {
	
	@Autowired
	EntityManager em;
	
	public InfoPaymentClub findById(Long id) {
		return em.find(InfoPaymentClub.class, id);
	}
	
	public InfoPaymentClub saveAndAffectToClub(InfoPaymentClub infoPaymentClub, Club club, TypePayment typePayment) {
			infoPaymentClub.setActive(false);
			infoPaymentClub.addClub(club);
			club.addinfoPaymentClubs(infoPaymentClub);
			infoPaymentClub.setType_payment(typePayment);
			em.persist(infoPaymentClub);
			em.persist(club);
			
		return infoPaymentClub;
	}
	
	public InfoPaymentClub update(InfoPaymentClub infoPaymentClub) {
		em.merge(infoPaymentClub);
		return infoPaymentClub;
	}
	
	public void activateInfopayment(InfoPaymentClub infoPaymentClub, Club club) {
		//désactiver l'info_payment en cours 
		Query query1 = em.createNativeQuery("update info_payment_club set active = false where club = :id_club", 
				InfoPaymentClub.class);
		query1.setParameter("id_club", club.getidClub());
		query1.executeUpdate();
		
		//activer l'info payment en question
		Query query2 = em.createNativeQuery("update info_payment_club set active=true where id_info_payment_club=:id_info_payment", 
				InfoPaymentClub.class);
		query2.setParameter("id_info_payment", infoPaymentClub.getId_info_payment_club());
		query2.executeUpdate();
	}
	
	
	
}
