package edu.mum.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.domain.UserOrder;
import edu.mum.domain.Product;
import edu.mum.repository.UserOrderRepository;
import edu.mum.repository.UserRepository;
import edu.mum.repository.AddressRepository;
import edu.mum.repository.CartRepository;
import edu.mum.repository.PaymentRepository;
import edu.mum.repository.ProductRepository;
import edu.mum.service.CartService;
import edu.mum.service.UserOrderService;

@Service
@Transactional
public class UserOrderServiceImpl implements UserOrderService{

	@Autowired
	private UserOrderRepository orderRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	private List<UserOrder> orders;
	
	public void processOrder(String productId, long quantity) {
//		Product productById = productRepository.getProductById(productId);
//		
//		if(productById.getUnitsInStock() < quantity){
//			throw new IllegalArgumentException("Out of Stock. Available Units in stock"+ productById.getUnitsInStock());
//		}
		
//		productById.setUnitsInStock(productById.getUnitsInStock() - quantity);
	}
	
	public UserOrder saveOrder(UserOrder order) {
		order.setPayment(paymentRepository.save(order.getPayment()));
		order.setCart(cartRepository.findOne(order.getCart().getId()));
		order.setShippingDetail(addressRepository.save(order.getShippingDetail()));
		order.setUser(userRepository.findOne(order.getUser().getId()));
		
//		cartService.delete(order.getCart().getCartId());
		return orderRepository.save(order);
	}
	
	public List<UserOrder> getOrdersByUserId(Long userId){
		orders = orderRepository.findAll();
		return orders.stream().filter(order->order.getUser().getId() == userId).collect(Collectors.toList());
	}

	@Override
	public UserOrder getUserOrder(Long orderId) {
		UserOrder userOrder = orderRepository.findOne(orderId);
		return userOrder;
	}

}
