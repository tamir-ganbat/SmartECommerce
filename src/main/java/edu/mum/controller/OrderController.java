package edu.mum.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.domain.Cart;
import edu.mum.domain.CartItem;
import edu.mum.domain.Product;
import edu.mum.domain.UserOrder;
import edu.mum.service.UserOrderService;

@Controller
public class OrderController {
	
	@Autowired
	UserOrderService userOrderService;
	
	@RequestMapping(value="/userOrders/{userId}")
	public String getOrders(@PathVariable("userId") String userId, Model model) {
		List<UserOrder> userOrders = userOrderService.getOrdersByUserId(Long.parseLong(userId));
		if(userOrders == null || userOrders.isEmpty()) {
			return "redirect:/products";
		}
		model.addAttribute("orders", userOrders);
		BigDecimal grandTotal = BigDecimal.ZERO;
		if(userOrders != null && !userOrders.isEmpty()) {
			for(UserOrder userOrder : userOrders) {
				grandTotal = grandTotal.add(userOrder.getOrderTotal());
			}
		}
		model.addAttribute("grandTotal", grandTotal);
		return "userOrders";
	}
	
	@RequestMapping(value="/orders/{orderId}", method=RequestMethod.GET)
	public String getOrderDetail(@PathVariable("orderId") String orderId, Model model, HttpSession session) {
		List<UserOrder> userOrders = userOrderService.getOrdersByUserId((long) session.getAttribute("userId"));
		List<UserOrder> currentOrder = userOrders.stream().filter(userOrder->userOrder.getId() == Long.parseLong(orderId)).collect(Collectors.toList());
		Cart currentCart = currentOrder.get(0).getCart();
		List<CartItem> cartItems = currentCart.getCartItems();
		model.addAttribute("cartItems", cartItems);
		return "orderDetail";
	}
	
	@RequestMapping(value="/confirm", method=RequestMethod.GET)
	public String getOrderDetail(HttpSession session) {
		session.setAttribute("cart", null);
		return "redirect: products";
	}
	
}
