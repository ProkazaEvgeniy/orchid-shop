package net.www.orchid.controller;

import static net.www.orchid.Constants.UI.MAX_PRODUCTS_PER_PAGE;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.www.orchid.entity.Product;
import net.www.orchid.service.CategoryService;
import net.www.orchid.service.ProductService;

@Controller
public class PublicDataController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CategoryService categoryService;

	// signup
	@RequestMapping(value = { "/signup" })
	public String signUp(Model model) {
		getNavigationBarForJSP(model);
		return gotoSignUpJSP();
	}

	private void getNavigationBarForJSP(Model model) {
		model.addAttribute("categorys", categoryService.allCategory());
		
	}

	private String gotoSignUpJSP() {
		return "signup";
	}// end signup

	// about-us
	@RequestMapping(value = { "/about-us" })
	public String aboutUs(Model model) {
		getNavigationBarForJSP(model);
		return gotoAboutUsJSP();
	}

	private String gotoAboutUsJSP() {
		return "about-us";
	}
	// end about-us

	// blog
	@RequestMapping(value = { "/blog" })
	public String blog(Model model) {
		getNavigationBarForJSP(model);
		return gotoBlogJSP();
	}

	private String gotoBlogJSP() {
		return "blog";
	}
	// end blog

	// details
	@RequestMapping(value = { "/details" })
	public String details(Model model, HttpServletRequest req) {
		getNavigationBarForJSP(model);
		model.addAttribute("product", productService.oneProductByID(Long.parseLong(req.getParameter("id"))));
		return gotoDetailsJSP();
	}

	private String gotoDetailsJSP() {
		return "details";
	}
	// end details

	// products
	@RequestMapping(value = { "/products" })
	public String products(@SortDefault(sort="id") Model model) {
		getNavigationBarForJSP(model);
		Page<Product> page = productService.findAll(new PageRequest(0, MAX_PRODUCTS_PER_PAGE, new Sort("id")));
		model.addAttribute("products", page.getContent());
		model.addAttribute("page", page);
 		return gotoProductsJSP();
	}

	private String gotoProductsJSP() {
		return "products";
	}
	
	@RequestMapping(value = "/fragment/more/products", method = RequestMethod.GET)
	public String moreProducts(
			Model model,
			@PageableDefault(size=MAX_PRODUCTS_PER_PAGE) @SortDefault(sort="id") Pageable pageable) throws UnsupportedEncodingException {
		Page<Product> page = productService.findAll(pageable);
		model.addAttribute("products", page.getContent());
		model.addAttribute("page", page);
		return gotoProductListJSP();
	}
	
	private String gotoProductListJSP() {
		return "fragment/products-list";
	}
	// end products

	// register
	@RequestMapping(value = { "/register" })
	public String register(Model model) {
		getNavigationBarForJSP(model);
		return gotoRegisterJSP();
	}

	private String gotoRegisterJSP() {
		return "register";
	}
	// end register

	// welcome
	@RequestMapping(value = { "/welcome" })
	public String welcome(Model model) {
		getNavigationBarForJSP(model);
		return gotoWelcomeJSP();
	}

	private String gotoWelcomeJSP() {
		return "welcome";
	}
	// end welcome
}
