package com.sport.gestionmuscu.jpaRepository.used;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sport.gestionmuscu.entity.SuperAdmin;

public interface SuperAdminJpaRep  extends JpaRepository<SuperAdmin,Long>{
	
	SuperAdmin findByLoginSuperAdminAndPassSuperAdmin(String loginSuperAmin, String passSuperAdmin);

}
