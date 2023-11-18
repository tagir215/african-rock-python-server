package com.tiger.designPatterns200.repository.component;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tiger.designPatterns200.entity.component.CaseEntity;

/**
 * @author OMISTAJA
 *
 */
@Repository
public interface CaseRepository extends JpaRepository<CaseEntity,Long>{
	

}
