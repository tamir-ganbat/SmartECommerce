package edu.mum.controller;

import org.springframework.stereotype.Controller;

@Controller
public class HomeController {

//	@RequestMapping({ "/", "/welcome" })
//	public String welcome(Model model) {
//		model.addAttribute("search", "");
//		model.addAttribute("greeting", "Welcome to our community, Kimosabe!!");
//		model.addAttribute("tagline", "The one and only place to live, work and play!!");
//
//		return "redirect:/products";
//	}

//	@ModelAttribute("homeTestOrder")
//	public String testOrder() {
//
//		// test interceptor Order
//		System.out.println("CONTROLLER @MODELATTRIBUTE PREHANDLE");
//
//		return "This is CONTROLLER ORDER!";
//	}
	
//	it can be in products method or ...
//	public String testOrder(@ModelAttribute("search") String search) {
////		List<Prodyct> list
//		Stream for list of product
//		then show result to customer
//		// test interceptor Order
//		System.out.println("CONTROLLER @MODELATTRIBUTE PREHANDLE");
//
//		return "This is CONTROLLER ORDER!";
//	}

//	@RequestMapping(method = RequestMethod.POST)
//	public String processAddNewProductForm(@Valid @ModelAttribute("newProduct") Product newProduct,
//			BindingResult result, Model model, HttpServletRequest request) {
//		MultipartFile productImage = newProduct.getProductImage();
//		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
//		if (productImage != null && !productImage.isEmpty()) {
//			try {
//				productImage.transferTo(
//						new File(rootDirectory + "resources\\images\\" + newProduct.getProductId() + ".png"));
//			} catch (Exception e) {
//				throw new RuntimeException("Product Image saving failed", e);
//			}
//		}
//		productService.addProduct(newProduct);
//		return "redirect:/products";
//	}

}
