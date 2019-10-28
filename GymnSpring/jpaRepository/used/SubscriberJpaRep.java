package com.sport.gestionmuscu.jpaRepository.used;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sport.gestionmuscu.entity.AdminClub;
import com.sport.gestionmuscu.entity.Subscriber;

public interface SubscriberJpaRep extends JpaRepository<Subscriber, Long>{
	 @Query(value = "SELECT * FROM subscriber where club=?1", nativeQuery = true)
	public List<Subscriber> findByClub(Long club);
}
