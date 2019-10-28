package com.sport.gestionmuscu.jpaRepository.used;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sport.gestionmuscu.entity.Club;
import com.sport.gestionmuscu.entity.Promotion;

public interface PromotionJpaRep extends JpaRepository<Promotion, Long>{
	public List<Promotion> findByClub(Club club);
}
