package edu.mum.repository;


import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.mum.domain.CartItem;

@Repository
public interface CartItemRepository extends CrudRepository<CartItem,Long>{
	
	@Modifying
	@Query(value = "Update CartItem c set totalPrice = ?1 , qty = ?2 where c.id = ?3", nativeQuery = true)
	public void updateCart(@Param("totalPrice") int totalPrice,@Param("qty") int qty, @Param("id") Long id);
}
