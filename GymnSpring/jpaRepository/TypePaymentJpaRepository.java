package com.sport.gestionmuscu.jpaRepository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sport.gestionmuscu.entity.TypePayment;

@Repository
@Transactional
public class TypePaymentJpaRepository {
	
	@Autowired
	EntityManager em;
	
	public TypePayment save(TypePayment typePayment) {
		 em.persist(typePayment);
		 return typePayment;		
}
	
}