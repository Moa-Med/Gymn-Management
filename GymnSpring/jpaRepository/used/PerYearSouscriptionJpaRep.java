package com.sport.gestionmuscu.jpaRepository.used;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sport.gestionmuscu.entity.Club;
import com.sport.gestionmuscu.entity.PerYearSubscription;

public interface PerYearSouscriptionJpaRep extends JpaRepository<PerYearSubscription, Long>{
	public List<PerYearSubscription> findByClub(Club club);
}
