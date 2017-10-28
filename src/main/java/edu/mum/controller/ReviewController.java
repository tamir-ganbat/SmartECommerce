package edu.mum.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import edu.mum.domain.Product;
import edu.mum.domain.Review;
import edu.mum.service.ProductService;
import edu.mum.service.ReviewService;

@Controller
public class ReviewController {

	@Autowired
	private ReviewService reviewService;
	
	@Autowired
	private ProductService productService;

	@RequestMapping(value = "/review/add", method = RequestMethod.GET)
	public String addReview(@ModelAttribute("newReview") Review newReview) {
		return "addReview";
	}

	@RequestMapping(value = "/review/add", method = RequestMethod.POST)
	public String saveReview(@RequestParam("id") Long productId, @ModelAttribute("newReview") @Valid Review review, BindingResult result,
			Model model) {
		
		if (result.hasErrors())
			return "addReview";
		
		Product tmpProduct = productService.getProductById(productId);
		review.setId(null);
		reviewService.addReview(review, tmpProduct);
		return "redirect:/product?id=" + productId;
	}

	@RequestMapping(value = "/reviewlist", method = RequestMethod.GET)
	public String getReview(Model model) {
		List<Review> reviewList = reviewService.getAllReviews();
		model.addAttribute("reviewList", reviewList);
		return "reviewList";
	}
}
