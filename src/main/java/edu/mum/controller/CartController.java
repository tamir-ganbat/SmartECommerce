package edu.mum.controller;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.SessionAttributes;

import edu.mum.domain.Cart;
import edu.mum.domain.CartItem;
import edu.mum.domain.Product;
import edu.mum.domain.User;
import edu.mum.domain.UserCredentials;
import edu.mum.repository.CartRepository;
import edu.mum.repository.ProductRepository;
import edu.mum.service.CartItemService;
import edu.mum.service.CartService;
import edu.mum.service.ProductService;
import edu.mum.service.UserCredentialsService;
import edu.mum.service.UserService;

@Controller
@SessionAttributes("cartItems")
public class CartController {
	
	
	@Autowired
	private UserCredentialsService userCredentialsService; 
	
	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private UserService userservice;
	
	@Autowired
	private ProductService productService;
	
	@Autowired 
	private CartItemService cartItemService;
	
	@RequestMapping(value= {"/cart"}, method = RequestMethod.GET)
	public String first(@ModelAttribute("cart")Cart cart,ModelMap model,HttpSession session) {
//		List<Cart> carts = (List<Cart>) cartRepository.findAll();
//		if(carts == null || carts.isEmpty()) {
//			return "products";
//		}
//		model.addAttribute("myCart",carts.get(0));
// 		return "cart";
		Cart usersCart = (Cart) session.getAttribute("cart");
		if(usersCart == null)
			return "redirect: products";
		model.addAttribute("myCart",usersCart);
 		return "cart";
	}
	
	@RequestMapping(value= {"/cart"}, method = RequestMethod.POST)
	public void second(@RequestParam("total") int total,@RequestParam("userName") String user,@RequestParam("productId") Long productId, 
			ModelMap model,Principal principal, HttpServletRequest request, CartItem cartItem, HttpSession session) {
		
//		System.out.println(productId +"-"+ user + "-"+ total);
		Product newProduct=productService.getProductById(productId);
//		System.out.println(newProduct.getName());
        String userName = request.getUserPrincipal().getName();
		
		UserCredentials credentials = userCredentialsService.findByUsername(user);
//		System.out.println(credentials);
		if(userName.equals(credentials.getUsername())) {
			int a=1;
			cartItem.setProduct(newProduct);
			cartItem.setQty(1);
			cartItem.setTotalPrice((int) (cartItem.getQty() * newProduct.getPrice()));
			Cart cart = session.getAttribute("cart") == null ? new Cart() : (Cart) session.getAttribute("cart");
			cart.setTotal(BigDecimal.valueOf(a));
			cart.setUser(credentials.getUser());
			cart = cartService.save(cart, cartItem);
			session.setAttribute("cart", cart);
//			reduceProducts(newProduct.getId());
		}
		
	}
	
//	private void reduceProducts(Long pId) {
//		// reduce one item from the product
//		
//		productService.decreaseProducts(pId);
//		
//	}

	@RequestMapping(value={"/cart"})
	public @ResponseBody Cart getCart(@PathVariable("Id") Long id){
		return cartService.findOne(id);
	}
	
	
//	@RequestMapping(value= {"/updateCart"}, method= RequestMethod.PUT)
//	public void updateCart(@RequestParam("quantity") int quantity,@RequestParam("user") String user,@RequestParam("productId") Long productId, ModelMap model,Principal principal, HttpServletRequest request,Cart cart){
//		Product newProduct=productService.getProductById(productId);
//        String userName = request.getUserPrincipal().getName();
//		
//		UserCredentials credentials = userCredentialsService.findByUsername(user);
//	
//		if(userName.equals(credentials.getUsername())) {
//			
//			cart.setProducts((List<Product>) newProduct);
//			cart.setTotal(BigDecimal.valueOf(a));
//			cart.setUser(credentials.getUser());
//			cartRepository.save(cart);
//			
//		}
//		
//		//cartRepository.save(cart);
//	}
//	
	
}
