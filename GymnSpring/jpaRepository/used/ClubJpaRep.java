package com.sport.gestionmuscu.jpaRepository.used;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sport.gestionmuscu.entity.AdminClub;
import com.sport.gestionmuscu.entity.Club;

public interface ClubJpaRep extends JpaRepository<Club, Long>{

	@Query(value="select * from club where id_club="
			+ "(select club from admin_club where login_admin_club=?1 and pass_admin_club=?2)",
			nativeQuery = true)
	Club findClubByLoginAndPassword(String loginAdminClub, String passAdminClub);
	
	@Query(value="select * from club where id_club="
			+ "(select club from admin_club where id_admin_club=?1)",
			nativeQuery = true)
	Optional<Club> findClubByIdAdminClub(Long idAdminClub);
	
	
}
