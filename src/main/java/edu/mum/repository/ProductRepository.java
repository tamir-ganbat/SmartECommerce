package edu.mum.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.mum.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	@Query("SELECT p FROM Product p WHERE p.id = :id")
	public Product getProductById(@Param("id") Long id);

	@Query("SELECT p FROM Product p WHERE p.category = :category")
	public List<Product> getProductsByCategory(@Param("category") String category, Pageable pageable);

	@Query("SELECT p FROM Product p WHERE p.category = ?2 and (p.manufacturer like %?1% or p.name like %?1% or p.description like %?1%)")
	public List<Product> findByNameAndCategory(String name, String category, Pageable pageable);

	@Query("SELECT p FROM Product p WHERE p.category in :categories")
	public List<Product> getProductsByFilter(@Param("categories") Map<String, List<String>> categories,
			Pageable pageable);

	@Query("SELECT p FROM Product p WHERE p.category like %:name% or p.manufacturer like %:name% or p.name like %:name% or p.description like %:name%")
	public List<Product> findByName(@Param("name") String name, Pageable pageable);

	@Query("SELECT p FROM Product p WHERE p.rate = :rate")
	public Double getRateById(@Param("rate") Double rate);

	@Modifying
	@Query("UPDATE Product u SET u.rate = ?1, u.rateNumber = ?2 WHERE u.id = ?3")
	void setRate(Double rate, Integer rateNumber, Long id);

	@Query("SELECT p.category FROM Product p group by p.category")
	public List<String> getCategories();
}
