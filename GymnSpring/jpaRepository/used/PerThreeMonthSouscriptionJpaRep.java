package com.sport.gestionmuscu.jpaRepository.used;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sport.gestionmuscu.entity.Club;
import com.sport.gestionmuscu.entity.PerThreeMonthSubscription;

public interface PerThreeMonthSouscriptionJpaRep extends JpaRepository<PerThreeMonthSubscription, Long>{
	public List<PerThreeMonthSubscription> findByClub(Club club);
}
