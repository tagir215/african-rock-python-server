package com.tiger.designPatterns200.repository.shoppingCart;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tiger.designPatterns200.entity.shoppingCart.CartItemEntity;

/**
 * @author OMISTAJA
 * I tried million things for these methods. 
 * Eager associations method doesn't seem to work for this type of data so I'm fetching all components separately by their id
 * found in the proxy
 */
public interface CartItemRepository extends JpaRepository<CartItemEntity,Long>{
	List<CartItemEntity> findAllByToken(String token);
	
	/**
	 * @param token
	 * @return
	 * this doesn't work. I tried million things
	 */
	@Query("SELECT c FROM CartItemEntity c " +
	           "LEFT JOIN FETCH c.motherboard " +
	           "LEFT JOIN FETCH c.caseEntity " +
	           "LEFT JOIN FETCH c.cpu " +
	           "LEFT JOIN FETCH c.cooler " +
	           "LEFT JOIN FETCH c.gpu " +
	           "LEFT JOIN FETCH c.storage " +
	           "LEFT JOIN FETCH c.ram " +
	           "LEFT JOIN FETCH c.powerUnit " +
	           "WHERE c.token = :token")
	List<CartItemEntity> findAllByTokenWithEagerAssociations(@Param("token") String token);
	
	
	void deleteAllByToken(String token);
}
