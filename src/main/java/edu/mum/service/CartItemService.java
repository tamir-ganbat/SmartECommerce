package edu.mum.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.domain.Cart;
import edu.mum.domain.CartItem;
import edu.mum.domain.Product;
import edu.mum.domain.User;

public interface CartItemService {

	public CartItem save(CartItem cartItem);

}
