package com.sport.gestionmuscu.jpaRepository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sport.gestionmuscu.entity.Picture;
import com.sport.gestionmuscu.entity.Subscriber;

@Repository
@Transactional
public class PictureJpaRepository {
	
	@Autowired
	EntityManager em;
	
	public Picture save(Picture picture) {
		if (picture.getId_picture()==null) {
			em.persist(picture);
		}
		else {
			em.merge(picture);
		}
		return picture;
	}
	
	public Picture affectPictureToSubscriber(Picture picture, Subscriber subscriber) {
		picture.setSubscriber(subscriber);
		subscriber.setPicture(picture);
		em.persist(subscriber);
		return picture;
	}

}
