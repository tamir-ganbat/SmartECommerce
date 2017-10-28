package edu.mum.controller;

import java.io.File;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import edu.mum.domain.Product;
import edu.mum.service.ProductService;
import edu.mum.service.ReviewService;

@Controller
public class ProductController {

	@Autowired
	private ProductService productService;

	@Autowired
	private ReviewService reviewService;

	@RequestMapping("/product")
	public String getProductById(@RequestParam("id") Long productId, Model model) {
		model.addAttribute("product", productService.getProductById(productId));
		model.addAttribute("reviews", reviewService.getProductById(productService.getProductById(productId)));
		return "product";
	}

	@RequestMapping("/products/search")
	public String list(@RequestParam("q") String q, Model model) {
		model.addAttribute("search",
				productService.findByName(q, new PageRequest(0, 9, Direction.DESC, "createdDate")));

		model.addAttribute("category", productService.getCategories());
		model.addAttribute("url", "/products/searchCategory?q=" + q);
		return "search";
	}

	@RequestMapping("/products/searchCategory")
	public String list2(@RequestParam("q") String q, @RequestParam("category") String c, Model model) {
		model.addAttribute("search",
				productService.findByNameAndCategory(q, c, new PageRequest(0, 9, Direction.DESC, "createdDate")));
		model.addAttribute("category", productService.getCategories());
		model.addAttribute("url", "/products/searchCategory?q=" + q);
		return "search";
	}

	@RequestMapping("/products/{category}")
	public String getProductsByCategory(Model model, @PathVariable("category") String productCategory) {
		model.addAttribute("products", productService.getProductsByCategory(productCategory,
				new PageRequest(0, 9, Direction.DESC, "createdDate")));
		return "products";
	}

	@RequestMapping({ "/products/filter/{params}" })
	public String getProductsByFilter(@MatrixVariable(pathVar = "params") Map<String, List<String>> filterParams,
			Model model) {
		model.addAttribute("products",
				productService.getProductsByFilter(filterParams, new PageRequest(0, 2, Direction.DESC, "createdDate")));
		return "products";
	}

	@RequestMapping(value = "/product/add", method = RequestMethod.GET)
	public String getAddNewProductForm(@ModelAttribute("newProduct") Product newProduct) {
		return "addProduct";
	}

	@RequestMapping(value = "/product/add", method = RequestMethod.POST)
	public String processAddNewProductForm(@ModelAttribute("newProduct") @Valid Product newProduct,
			BindingResult result, HttpServletRequest request, Model model) {

		if (result.hasErrors())
			return "addProduct";

		String[] suppressedFields = result.getSuppressedFields();
		if (suppressedFields.length > 0) {
			throw new RuntimeException("Attempting to bind disallowed fields: "
					+ StringUtils.arrayToCommaDelimitedString(suppressedFields));
		}

		productService.addProduct(newProduct);

		MultipartFile image = newProduct.getImage();
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");

		if (image != null && !image.isEmpty()) {
			try {
				image.transferTo(new File(rootDirectory + "resources//images//" + newProduct.getId() + ".jpg"));
				System.out.print(rootDirectory + "resources\\images\\" + newProduct.getId() + ".jpg");
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("Product Image saving failed", e);
			}
		}
		return "redirect:/products";
	}

//	@InitBinder
//	public void initialiseBinder(WebDataBinder binder) {
//		binder.setAllowedFields("id", "name", "price", "description", "category", "qty", "image", "manufacturer");
//	}
	
	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public String listPages(Model model) {
		Page<Product> page = productService.getPage(1);

		int current = page.getNumber() + 1;
		int begin = Math.max(1, current - 5);
		int end = Math.min(begin + 5, page.getTotalPages());

		model.addAttribute("page", page);
		model.addAttribute("beginIndex", begin);
		model.addAttribute("endIndex", end);
		model.addAttribute("currentIndex", current);
		model.addAttribute("products", productService.getAllProducts(1));

		return "products";
	}

	@RequestMapping(value = "/products/pages/{pageNumber}", method = RequestMethod.GET)
	public String listPages(Model model, @PathVariable Integer pageNumber) {
		Page<Product> page = productService.getPage(pageNumber);

		int current = page.getNumber() + 1;
		int begin = Math.max(1, current - 5);
		int end = Math.min(begin + 5, page.getTotalPages());

		model.addAttribute("page", page);
		model.addAttribute("beginIndex", begin);
		model.addAttribute("endIndex", end);
		model.addAttribute("currentIndex", current);
		model.addAttribute("products", productService.getAllProducts(pageNumber));
		return "products";
	}

	@RequestMapping(value = "search")
	public String Search(@RequestParam("searchString") String searchString, @PathVariable Integer pageNumber) {

//		Page<Product> page = productService.getPage(1);
		if (searchString != null) {
			productService.findByName(searchString, new PageRequest(0, 2, Direction.DESC, "createdDate"));
		}

		return "products";
	}
}
