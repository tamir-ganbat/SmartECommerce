package edu.mum.service;

import java.util.List;

import edu.mum.domain.Product;
import edu.mum.domain.Review;

public interface ReviewService {

	List<Review> getAllReviews();

	List<Review> getProductById(Product product);

	void addReview(Review review, Product product);
}
