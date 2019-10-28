package com.sport.gestionmuscu.jpaRepository.used;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sport.gestionmuscu.entity.AdminClub;

public interface AddAdminJpaRep extends JpaRepository<AdminClub, Long>{
	 @Query(value = "SELECT * FROM subscriber where club=?1", nativeQuery = true)
		public List<AddAdminJpaRep> findByClub(Long club);
}
