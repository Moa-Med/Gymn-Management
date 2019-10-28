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

import com.sport.gestionmuscu.entity.Activity;
import com.sport.gestionmuscu.entity.AdminClub;
import com.sport.gestionmuscu.entity.Club;

@Repository
@Transactional
public class ClubJpaRepository {
	
	@Autowired
	EntityManager em;
	
	public Club findById(Long id_club){
		return em.find(Club.class, id_club);
	}
	
	
	public Club save(Club Club){
		if (Club.getidClub()==null) {
			em.persist(Club);
		}else 
		{
			em.merge(Club);
		}
		return Club;
	}
	
	public List<Club> listClub(){
		return em.createQuery("select c from Club c",Club.class).getResultList();
	}
	
	public void addActivityToClub(Club club, Activity activity) {
		club.addActivity(activity);
		activity.addClub(club);
		em.persist(club);
	}
	
public void addAdminClubToClub(AdminClub adminClub, Club club) {
		adminClub.setClub(club);
		club.addadminClub(adminClub);
		em.persist(adminClub);
	}
	
	/*
	public void deleteById(Long id_club){
		Club Club = em.find(Club.class, id_club);
		em.remove(Club);
	}
	
	
	public List<Club> listClubFromNativeQuery(){
		Query query = em.createNativeQuery("select * from Club", Club.class);
		List resutl = query.getResultList();
		return resutl;
	}
	
	public List<Club> searchClubById(Long id){
		Query query = em.createNativeQuery("select * from Club where id_Club= :id", Club.class);
		query.setParameter("id", id);
		List resutl = query.getResultList();
		return resutl;
	}
	
	*/
}
