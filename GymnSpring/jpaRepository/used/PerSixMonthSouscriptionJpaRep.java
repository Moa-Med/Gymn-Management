package com.sport.gestionmuscu.jpaRepository.used;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sport.gestionmuscu.entity.Club;
import com.sport.gestionmuscu.entity.PerSixMonthSubscription;

public interface PerSixMonthSouscriptionJpaRep extends JpaRepository<PerSixMonthSubscription, Long>{
	public List<PerSixMonthSubscription> findByClub(Club club);
}
