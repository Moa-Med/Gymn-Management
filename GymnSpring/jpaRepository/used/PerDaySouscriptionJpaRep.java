package com.sport.gestionmuscu.jpaRepository.used;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sport.gestionmuscu.entity.Club;
import com.sport.gestionmuscu.entity.PerDaySubscription;

public interface PerDaySouscriptionJpaRep extends JpaRepository<PerDaySubscription, Long>{
	public List<PerDaySubscription> findByClub(Club club);
}
