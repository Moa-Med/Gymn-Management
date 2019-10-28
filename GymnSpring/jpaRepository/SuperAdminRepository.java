package com.sport.gestionmuscu.jpaRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.annotation.ApplicationScope;

import com.sport.gestionmuscu.entity.AdminClub;
import com.sport.gestionmuscu.entity.Club;
import com.sport.gestionmuscu.entity.SuperAdmin;


@Repository
@Transactional
public class SuperAdminRepository {

	@Autowired
	EntityManager em;
	
	public SuperAdmin findById(Long idSuperAdmin){
		return em.find(SuperAdmin.class, idSuperAdmin);
	}
	
	
	public SuperAdmin save(SuperAdmin SuperAdmin){
		if (SuperAdmin.getIdSuperAdmin()==null) {
			em.persist(SuperAdmin);
		}else 
		{
			em.merge(SuperAdmin);
		}
		return SuperAdmin;
	}
	
	public void deleteById(Long id){
		SuperAdmin SuperAdmin = em.find(SuperAdmin.class, id);
		em.remove(SuperAdmin);
	}
	
	
	}
