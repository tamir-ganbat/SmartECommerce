package edu.mum.controller;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import edu.mum.domain.Product;
import edu.mum.service.ProductService;

@RestController
@RequestMapping(value="/rest/product")
public class ProductRestController {

	@Autowired
	private ProductService productService;

	@RequestMapping(value = "/{productId}")
	public @ResponseBody Product getProductById(@PathVariable(value="productId") Long productId, @RequestBody Product product) {
		return productService.getProductById(productId);
	}
	
/*	@RequestMapping(value = "/{productId}", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.OK)
	public void update(@PathVariable(value = "productId") Long productId, @RequestBody Product product) {
		product.setId(productId);
		productService.update(productId, product);
	}
	
	@RequestMapping(value = "/{productId}", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.OK)
	public void delete(@PathVariable(value = "productId") Long productId) {
		productService.delete(productId);
	}
	
	@RequestMapping(value = "/add/{productId}", method=RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.OK)
	public void addProduct(@PathVariable Long productId, HttpSession session) {
		productService.addProduct(session.getId(), productId);
	}

	@RequestMapping(value = "/remove/{productId}", method=RequestMethod.PUT)
	@ResponseStatus (value = HttpStatus.OK)
	public void removeProduct(@PathVariable Long productId, HttpSession session) {
		productService.removeProduct(session.getId(), productId);
	}*/
}
