package com.sport.gestionmuscu.jpaRepository.used;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sport.gestionmuscu.entity.Club;
import com.sport.gestionmuscu.entity.PerDaySubscription;
import com.sport.gestionmuscu.entity.PerMonthSubscription;

public interface PerMonthSouscriptionJpaRep extends JpaRepository<PerMonthSubscription, Long>{
	public List<PerMonthSubscription> findByClub(Club club);
}
