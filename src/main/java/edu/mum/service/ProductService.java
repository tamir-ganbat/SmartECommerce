package edu.mum.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import edu.mum.domain.Product;

public interface ProductService {
	
	List<Product> getAllProducts(int pageNumber);

	List<Product> getProductsByCategory(String category, PageRequest pagerequest);

	List<Product> getProductsByFilter(Map<String, List<String>> filterParams, PageRequest pagerequest);
	
	List<Product> findByName(String name, PageRequest pagerequest);
	
	List<Product> findByNameAndCategory(String name, String category, PageRequest pagerequest);
	
	List<Product> findAll(String name, PageRequest pagerequest);
	
	List<String> getCategories();

	Product getProductById(Long productId);
	
	Double getRateById(Double productId);
	
	void setRate(Double rate, Integer totalRate, Long id);
	
	void addProduct(Product product);
	
	Page<Product> getPage(int pageNumber);
	
// REST	

//	void update(Long productId, Product product);

	void delete(Long productId);
//
//	void addProduct(String id, Long productId);
//
//	void removeProduct(String id, Long productId);
}
