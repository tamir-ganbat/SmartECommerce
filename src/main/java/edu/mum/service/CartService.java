package edu.mum.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.domain.Cart;
import edu.mum.domain.CartItem;
import edu.mum.domain.Product;
import edu.mum.domain.User;

public interface CartService {

	public Cart save(Cart cart, CartItem cartItem);

	public void saveCustomCart(int total, Product newProduct, User user);
	
	public Cart findOne(Long cartId);

}
