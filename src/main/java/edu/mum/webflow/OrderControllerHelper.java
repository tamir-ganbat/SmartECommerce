package edu.mum.webflow;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.mum.domain.Address;
import edu.mum.domain.Cart;
import edu.mum.domain.Payment;
import edu.mum.domain.User;
import edu.mum.domain.UserCredentials;
import edu.mum.domain.UserOrder;
import edu.mum.repository.CartRepository;
import edu.mum.service.CartService;
import edu.mum.service.UserCredentialsService;
import edu.mum.service.UserOrderService;
import edu.mum.service.UserService;

@Component
public class OrderControllerHelper {
	
	@Autowired
	private CartRepository cartRepository;

	@Autowired
	CartService cartService;
	
	@Autowired
	UserOrderService userOrderService;
	
	@Autowired
	UserCredentialsService usercredentialsservice;
	
	@Autowired
	UserService userService;
	
	public UserOrder calculateShippingAndTax(UserOrder userOrder) {
		Date shippingDate = userOrder.getOrderDate();
		Date now = new Date();
		int diffInDays = (int)( (shippingDate.getTime() - now.getTime()) 
                / (1000 * 60 * 60 * 24));
		
		if(diffInDays < 3 && userOrder.getOrderTotal().compareTo(new BigDecimal(25)) < 0) {
			userOrder.setShipping(new BigDecimal(10));
		}
		else if(diffInDays < 8 && userOrder.getCart().getTotal().compareTo(new BigDecimal(25)) < 0) {
			userOrder.setShipping(new BigDecimal(5));
		}
		
		userOrder.setTax(userOrder.getCart().getTotal().divide(new BigDecimal(10)));
		
		userOrder.setOrderTotal(userOrder.getShipping().add(userOrder.getTax()));
		userOrder.setOrderTotal(userOrder.getCart().getTotal().add(userOrder.getOrderTotal()));

		return userOrder;
	}
	
	public UserOrder saveOrder(UserOrder order) {
//		System.out.println("HERE IS SaveOrder Of OrderController Helper");
		UserOrder result = userOrderService.saveOrder(order);
		return result;
	}
	
	public UserOrder validateCart(String pCartId, String pTotalPrice, String pUserId) {
		
		Long cartId =  Long.parseLong(pCartId);
		BigDecimal totalPrice = new BigDecimal(pTotalPrice);
		Long userId =  Long.parseLong(pUserId);
		List<Cart> carts = (List<Cart>) cartRepository.findAll();
		if(carts != null && !carts.isEmpty()) {
			Cart cart = new Cart();
			for(Cart ct : carts) {
				if(ct.getId() == cartId) {
					cart = ct;
				}
			}
			if(cart.getId() == null)
				return null;
			
			UserOrder newUserOrder = new UserOrder();
			User newUser = userService.findOne(userId);
			newUserOrder.setUser(newUser);
			newUserOrder.setCart(cart);
			newUserOrder.setOrderDate(new Date());
			newUserOrder.setShippingDetail(new Address());
			newUserOrder.setPayment(new Payment());
			newUserOrder.setOrderTotal(totalPrice);
			newUserOrder.setOrderTotal(newUserOrder.getOrderTotal().add(newUserOrder.getShipping()));
			newUserOrder.setShippingDetail(newUserOrder.getUser().getAddress());
			return newUserOrder;
		}
		else 
			return null;
	}
}
