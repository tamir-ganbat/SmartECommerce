package edu.mum.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.domain.Product;
import edu.mum.domain.Review;
import edu.mum.repository.ProductRepository;
import edu.mum.repository.ReviewRepository;
import edu.mum.service.ReviewService;

@Service
@Transactional
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	private ReviewRepository reviewRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public List<Review> getAllReviews() {
		return (List<Review>) reviewRepository.findAll();
	}
	
	@Override
	public void addReview(Review review, Product product) {
		review.setProduct(product);
		reviewRepository.save(review);
		productRepository.setRate(review.getRate() + product.getRate(), product.getRateNumber() + 1, product.getId());
	}

	@Override
	public List<Review> getProductById(Product product) {
		return reviewRepository.getProductById(product);
	}
}
