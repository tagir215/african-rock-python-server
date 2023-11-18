package com.tiger.designPatterns200.repository.component;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tiger.designPatterns200.entity.component.ComponentEntity;

/**
 * @author OMISTAJA
 * used in the initialization and when uploading new data
 */
@Repository
public interface ComponentRepository extends JpaRepository<ComponentEntity, Long> {
	
	@Query("SELECT c from ComponentEntity c WHERE TYPE(c) = :clazz AND c.id = :id")
	Optional<ComponentEntity>findByClassAndId(
			@Param("clazz") Class<? extends ComponentEntity>clazz,
			@Param("id") Long id
	);

	@Query("SELECT c from ComponentEntity c WHERE TYPE(c) = :clazz")
	List<ComponentEntity>findAllByClass(@Param("clazz") Class<? extends ComponentEntity>clazz);
		
	
	 @Query("SELECT c FROM ComponentEntity c WHERE TYPE(c) = :clazz AND c.id IN :ids")
		List<ComponentEntity> findAllByClassAndIdIn(
			@Param("clazz") Class<? extends ComponentEntity> clazz,
			@Param("ids") List<Long> ids
	 );
}
