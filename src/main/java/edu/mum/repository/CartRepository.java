package edu.mum.repository;


import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.mum.domain.Cart;
import edu.mum.domain.Product;
import edu.mum.domain.User;

@Repository
public interface CartRepository extends CrudRepository<Cart,Long>{
	
	@Modifying
	@Query(value = "insert into Cart (total, product, buyerId) VALUES (?1,?2,?3)", nativeQuery = true)
	//public void saveCustomCart(int total,Product newProduct, User user);
	public void saveCustomCart(@Param("total") int total,@Param("product") Product newProduct,@Param("buyerId") User user);
	
//	
//	@Modifying
//	@Query(value = "Update Cart c set total = ?1 where product = ?2", nativeQuery = true)
//	public void updateCart(@Param("total") int total, @Param("product") Product newProduct);
//
	
	@Modifying
	@Query(value = "Update Cart c set total = ?1 where c.id = ?2", nativeQuery = true)
	public void updateCart(@Param("total") int total, @Param("id") Long id);
//	@Query(value="select c from Cart c where c.product =: productId")
//	public Cart getByProductId(Long productId);
	
}
