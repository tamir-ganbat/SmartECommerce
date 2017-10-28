package edu.mum.service;

import java.util.List;

import edu.mum.domain.UserOrder;

public interface UserOrderService {
	
	void processOrder(String  productId, long quantity);
	
	UserOrder saveOrder(UserOrder order);
	
	List<UserOrder> getOrdersByUserId(Long userId);
	
	UserOrder getUserOrder(Long orderId);
	
}
