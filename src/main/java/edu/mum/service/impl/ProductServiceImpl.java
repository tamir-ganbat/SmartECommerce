package edu.mum.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.domain.Product;
import edu.mum.repository.ProductRepository;
import edu.mum.service.ProductService;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	private static final int PAGESIZE = 9;
	
	@Autowired
	private ProductRepository productRepository;

	public Page<Product> getPage(int pageNumber) {
		PageRequest request = new PageRequest(pageNumber - 1, PAGESIZE, Sort.Direction.ASC, "id");
		return productRepository.findAll(request);
	}
	
	@Override
	public List<Product> getAllProducts(int pageNumber) {
		PageRequest request = new PageRequest(pageNumber - 1, PAGESIZE, Sort.Direction.ASC, "id");
		return productRepository.findAll(request).getContent();
	}

	@Override
	public void addProduct(Product product) {
		productRepository.save(product);
	}

	@Override
	public List<Product> getProductsByCategory(String category, PageRequest pagerequest) {
		return (List<Product>) productRepository.getProductsByCategory(category, pagerequest);
	}

	@Override
	public Product getProductById(Long productId) {
		return productRepository.getProductById(productId);
	}

	@Override
	public List<Product> getProductsByFilter(Map<String, List<String>> filterParams, PageRequest pagerequest) {
		return (List<Product>) productRepository.getProductsByFilter(filterParams, pagerequest);
	}

	@Override
	public List<Product> findByName(String name, PageRequest pagerequest) {
		return (List<Product>) productRepository.findByName(name, pagerequest);
	}

	@Override
	public Double getRateById(Double productId) {
		return productRepository.getRateById(productId);
	}

	@Override
	public void setRate(Double rate, Integer totalRate, Long id) {
		productRepository.setRate(rate, totalRate, id);		
	}

	@Override
	public List<Product> findAll(String name, PageRequest pagerequest) {
		return productRepository.findAll();
	}

	@Override
	public List<String> getCategories() {
		return productRepository.getCategories();
	}

	@Override
	public List<Product> findByNameAndCategory(String name, String category, PageRequest pagerequest) {
		return productRepository.findByNameAndCategory(name, category, pagerequest);
	}

//	@Override
//	public void update(Long productId, Product product) {
//		productRepository.update(product);
//		
//	}

	@Override
	public void delete(Long productId) {
		productRepository.delete(productId);
	}
//
//	@Override
//	public void addProduct(String id, Long productId) {
//		productRepository.save(product);
//		
//	}
//
//	@Override
//	public void removeProduct(String id, Long productId) {
//		// TODO Auto-generated method stub
//		
//	}

}
