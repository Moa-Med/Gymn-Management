package com.sport.gestionmuscu.jpaRepository.used;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sport.gestionmuscu.entity.AdminClub;
import com.sport.gestionmuscu.entity.Club;
import com.sport.gestionmuscu.entity.Subscriber;

public interface AdminClubJpaRep extends JpaRepository<AdminClub, Long>{

	@Query(value = "SELECT * FROM admin_club", nativeQuery = true)
	AdminClub findByLoginAdminClubAndPassAdminClub(String loginAdminClub, String passAdminClub);
	//List<AdminClub> findByIdAdminClub(Long idAdminClub);
	List<AdminClub> findByClub(Club club);

}

