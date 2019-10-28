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

@Repository
@Transactional
public class ActivityJpaRepository {
	
	@Autowired
	EntityManager em;
	
	public Activity findById(Long idActivity){
		return em.find(Activity.class, idActivity);
	}
	
	
	public Activity save(Activity activity){
		if (activity.getId_activity()==null) {
			em.persist(activity);
		}else 
		{
			em.merge(activity);
		}
		return activity;
	}
	/*
	public void deleteById(Long idActivity){
		Activity activity = em.find(Activity.class, idActivity);
		em.remove(activity);
	}
	
	public List<Activity> listActivity(){
		return em.createQuery("select a from Activity a",Activity.class).getResultList();
	}
	
	public List<Activity> listActivityFromNativeQuery(){
		Query query = em.createNativeQuery("select * from activity", Activity.class);
		List resutl = query.getResultList();
		return resutl;
	}
	
	public List<Activity> searchActivityById(Long id){
		Query query = em.createNativeQuery("select * from activity where id_Activity= :id", Activity.class);
		query.setParameter("id", id);
		List resutl = query.getResultList();
		return resutl;
	}
	
	
	
	*/
}
