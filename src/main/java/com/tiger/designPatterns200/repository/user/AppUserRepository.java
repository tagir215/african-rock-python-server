package com.tiger.designPatterns200.repository.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tiger.designPatterns200.entity.user.AppUser;

/**
 * @author OMISTAJA
 *
 */
@Repository
@Transactional(readOnly=true)
public interface AppUserRepository extends JpaRepository<AppUser,Long>{
	Optional<AppUser>findByEmail(String email);
	
	/**
	 * @param email
	 * @return
	 */
	@Transactional
    @Modifying
    @Query("UPDATE AppUser a SET a.enabled = TRUE WHERE a.email = ?1")
    int enableAppUser(String email);
	
	
}
