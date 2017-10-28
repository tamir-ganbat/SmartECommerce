package edu.mum.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.domain.CartItem;
import edu.mum.repository.CartItemRepository;
import edu.mum.service.CartItemService;

@Service
@Transactional
public class CartItemServiceImpl implements CartItemService {

	@Autowired
	private CartItemRepository cartItemRepository;

	public CartItem save(CartItem cartItem) {
		return cartItemRepository.save(cartItem);
	}

}
