package edu.mum.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.domain.Cart;
import edu.mum.domain.CartItem;
import edu.mum.domain.Product;
import edu.mum.domain.User;
import edu.mum.repository.CartItemRepository;
import edu.mum.repository.CartRepository;
import edu.mum.service.CartService;

@Service
@Transactional
public class CartServiceImpl implements CartService {

	@Autowired
	private CartRepository cartRepository;

	@Autowired
	private CartItemRepository cartItemRepository;

	@Override
	public Cart save(Cart cart, CartItem cartItem) {
		Cart result = cart;
		if (result.getId() == null) {
			cartItem = cartItemRepository.save(cartItem);
			result.getCartItems().add(cartItem);
			result = cartRepository.save(cart);
		} else {
			result = cartRepository.findOne(cart.getId());
//			List<CartItem> cartItems = (List<CartItem>) cartItemRepository.save(cart.getCartItems());
			List<CartItem> cartItems = result.getCartItems();
			if(cartItems.isEmpty()) {
				cartItems.add(cartItemRepository.save(cartItem));
			}
			else {
			boolean isExist = false;
				for(CartItem cItem : cartItems) {
					if(cItem.getProduct().getId() == cartItem.getProduct().getId()) {
						isExist = true;
						cItem.setQty(cItem.getQty() + 1);
						cItem.setTotalPrice((int) (cItem.getTotalPrice() + cItem.getProduct().getPrice()));
						continue;
					}
				}
				if(!isExist) {
					cartItems.add(cartItemRepository.save(cartItem));
				}
			}
			int total = 0;
			for (CartItem cItem : cartItems) {
				total += cItem.getTotalPrice();
			}

			cartRepository.updateCart(total, result.getId());
		}
		return result;
	}

	@Override
	public void saveCustomCart(int i, Product newProduct, User string) {

		cartRepository.saveCustomCart(i, newProduct, string);

	}

	@Override
	public Cart findOne(Long cartId) {
		return cartRepository.findOne(cartId);
	}

}
