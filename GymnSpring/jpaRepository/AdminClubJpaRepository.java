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

@Repository
@Transactional
public class AdminClubJpaRepository {
	
	@Autowired
	EntityManager em;
	
	public AdminClub findById(Long idAdminClub){
		return em.find(AdminClub.class, idAdminClub);
	}
	
	
	public AdminClub addAdminClub(AdminClub adminClub, Club club){
		adminClub.setClub(club);
		club.addadminClub(adminClub);
		em.persist(adminClub);	
		return adminClub;
	}
	
	public AdminClub updateAdminClub(AdminClub adminClub){		
		em.merge(adminClub);	
		return adminClub;
}
	
	public List<AdminClub> listAdminClubByClub(Long id_club) {
		Query query=em.createNativeQuery("select * from admin_club where club=:id",AdminClub.class);
		query.setParameter("id", id_club);
		return (List<AdminClub>)query.getResultList();
	}
	
	public AdminClub findByLoginAndPass(String login, String pass) {
		Query query=em.createNativeQuery("select * from admin_club where login_admin_club=:login and pass_admin_club=:pass",AdminClub.class);
		query.setParameter("login", login);
		query.setParameter("pass", pass);
		return (AdminClub) query.getResultList();
	}
	
	
	/*
	public void deleteById(Long idAdminClub){
		AdminClub AdminClub = em.find(AdminClub.class, idAdminClub);
		em.remove(AdminClub);
	}
	
	public List<AdminClub> listAdminClub(){
		return em.createQuery("select a from AdminClub a",AdminClub.class).getResultList();
	}
	
	public List<AdminClub> listAdminClubFromNativeQuery(){
		Query query = em.createNativeQuery("select * from AdminClub", AdminClub.class);
		List resutl = query.getResultList();
		return resutl;
	}
	
	public List<AdminClub> searchAdminClubById(Long id){
		Query query = em.createNativeQuery("select * from AdminClub where id_AdminClub= :id", AdminClub.class);
		query.setParameter("id", id);
		List resutl = query.getResultList();
		return resutl;
	}
	
	*/
}
