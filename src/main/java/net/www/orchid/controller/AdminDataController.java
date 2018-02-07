package net.www.orchid.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import net.www.orchid.entity.Category;
import net.www.orchid.entity.Lenght;
import net.www.orchid.entity.Producer;
import net.www.orchid.entity.Product;
import net.www.orchid.form.CategoryForm;
import net.www.orchid.form.LenghtForm;
import net.www.orchid.form.ProducerForm;
import net.www.orchid.form.ProductForm;
import net.www.orchid.service.AdminService;
import net.www.orchid.service.ProductService;

@Controller
public class AdminDataController {

	@Autowired
	private AdminService adminService;
	
	@Autowired
	private ProductService productService;

	// admin/welcome
	@RequestMapping(value = { "/admin/welcome" })
	public String welcomeAdmin(Model model) {
		loadAllCategoryProducerLenght(model);
		return gotoWelcomeAdmin();
	}

	private String gotoWelcomeAdmin() {
		return "admin/welcome";
	}
	
	private void loadAllCategoryProducerLenght(Model model){
		getAllCategory(model);
		model.addAttribute("producers", adminService.allProducer());
		model.addAttribute("lenghts", adminService.allLenght());
	}
	// end admin/welcome

	private void getAllCategory(Model model) {
		model.addAttribute("categorys", adminService.allCategory());
	}

		/**/
	// admin/save-lenght
		@RequestMapping(value = { "/admin/save-lenght" }, method = RequestMethod.POST)
		public String saveLenghtAdmin(@ModelAttribute("lenghtForm") LenghtForm lenghtForm) {
			adminService.addLenght(lenghtForm);
			return redirectAdminWelcomeJSP();
		}
		// end admin/save-lenght

		// admin/all-lenghts
		@RequestMapping(value = { "/admin/all-lenghts" }, method = RequestMethod.GET)
		public String allLenghtsAdmin(Model model) {
			getAllCategory(model);
			List<Lenght> lenghts = adminService.allLenght();
			model.addAttribute("lenghts", lenghts);
			return gotoAllLenghtsAdmin();
		}

		private String gotoAllLenghtsAdmin() {
			return "admin/all-lenghts";
		}
		// end admin/all-producers
		
		// admin/deleteLenght
		@RequestMapping(value = { "/admin/deleteLenght" })
		public String deleteLenght(HttpServletRequest req) {
			adminService.deleteLenght(Integer.parseInt(req.getParameter("id")));
			return "redirect:/admin/all-lenghts";
		}
		// end admin/deleteLenght
	/**/
	
	// admin/save-producer
	@RequestMapping(value = { "/admin/save-producer" }, method = RequestMethod.POST)
	public String saveProducerAdmin(@ModelAttribute("producerForm") ProducerForm producerForm) {
		adminService.addProducer(producerForm);
		return redirectAdminWelcomeJSP();
	}

	private String redirectAdminWelcomeJSP() {
		return "redirect:/admin/welcome";
	}
	// end admin/save-producer
	
	//
	@RequestMapping(value = {"/admin/edit-producer"}, method = RequestMethod.GET)
	public String gotoEditProducerAdmin(Model model, HttpServletRequest req){
		getAllCategory(model);
		model.addAttribute("producer", adminService.oneProducerByID(Long.parseLong(req.getParameter("id"))));
		return "admin/edit-producer";
	}
	
	@RequestMapping(value = {"/admin/edit-producer"}, method = RequestMethod.POST)
	public String editProducerAdmin(@ModelAttribute("producerForm") Producer producerForm, HttpServletRequest req){
		adminService.updateProducer(Long.parseLong(req.getParameter("id")), producerForm);
		return "redirect:/admin/all-producers";
	}
	
	//

	// admin/all-producers
	@RequestMapping(value = { "/admin/all-producers" }, method = RequestMethod.GET)
	public String allProducersAdmin(Model model) {
		getAllCategory(model);
		List<Producer> producers = adminService.allProducer();
		model.addAttribute("producers", producers);
		return gotoAllProducersAdmin();
	}

	private String gotoAllProducersAdmin() {
		return "admin/all-producers";
	}
	// end admin/all-producers
		
	// admin/deleteProducer
	@RequestMapping(value = { "/admin/deleteProducer" })
	public String deleteProducer(HttpServletRequest req) {
		adminService.deleteProducer(Long.parseLong(req.getParameter("id")));
		return "redirect:/admin/all-producers";
	}
	// end admin/deleteProducer
	
	// admin/save-category
	@RequestMapping(value = { "/admin/save-category" }, method = RequestMethod.POST)
	public String saveCategoryAdmin(@ModelAttribute("categoryForm") CategoryForm categoryForm) {
		adminService.addCategory(categoryForm);
		return redirectAdminWelcomeJSP();
	}
	// end admin/save-category

	// admin/all-categorys
	@RequestMapping(value = { "/admin/all-categorys" }, method = RequestMethod.GET)
	public String allCategorysAdmin(Model model) {
		getAllCategory(model);
		return gotoAllCategorysAdmin();
	}

	private String gotoAllCategorysAdmin() {
		return "admin/all-categorys";
	}
	// end admin/all-categorys
	
	// admin/deleteCategory
	@RequestMapping(value = { "/admin/deleteCategory" })
	public String deleteCategory(HttpServletRequest req) {
		adminService.deleteCategory(Long.parseLong(req.getParameter("id")));
		return "redirect:/admin/all-categorys";
	}
	// end admin/deleteCategory
	
	// admin/edit-category
	@RequestMapping(value = { "/admin/edit-category" }, method = RequestMethod.GET)
	public String gotoEditCategory(Model model, HttpServletRequest req) {
		getAllCategory(model);
		model.addAttribute("category", adminService.oneCategoryByID(Long.parseLong(req.getParameter("id"))));
		return "admin/edit-category";
	}
	
	@RequestMapping(value = { "/admin/edit-category" }, method = RequestMethod.POST)
	public String editCategory(@ModelAttribute("categoryForm") Category categoryForm, HttpServletRequest req) {
		adminService.updateCategory(Long.parseLong(req.getParameter("id")), categoryForm);
		return "redirect:/admin/all-categorys";
	}
	// end admin/edit-category
	
	// admin/save-product
	@RequestMapping(value = "/admin/save-product", method = RequestMethod.POST)
	public String saveProduct(@ModelAttribute("productForm") ProductForm productForm,
			@RequestParam("productPhoto") MultipartFile uploadPhoto){
		adminService.createdProductData(productForm, uploadPhoto);
		return  redirectAdminWelcomeJSP();
	}
	// end admin/save-product
	
	// admin/edit-product
	@RequestMapping(value = "/admin/edit-product", method = RequestMethod.GET)
	public String editProductAdmin(Model model, HttpServletRequest req){
		loadAllCategoryProducerLenght(model);
		model.addAttribute("product", productService.oneProductByID(Long.parseLong(req.getParameter("id"))));
		return gotoEditProductAdmin();
	}
	
	private String gotoEditProductAdmin() {
		return "admin/edit-product";
	}
	
	@RequestMapping(value = "/admin/edit-product", method = RequestMethod.POST)
	public String editProductAdmin(@ModelAttribute("productForm") Product productForm, 
			@RequestParam("productPhoto") MultipartFile uploadPhoto, HttpServletRequest req){
		adminService.updateProduct(Long.parseLong(req.getParameter("id")),
				productForm, uploadPhoto);
		return "redirect:/products";
	}
	
	// end admin/edit-product
	
	// admin/all-product
	@RequestMapping(value = { "/admin/all-products" }, method = RequestMethod.GET)
	public String allProductAdmin(Model model) {
		getAllProduct(model);
		return gotoAllProductsAdmin();
	}
	
	private String gotoAllProductsAdmin() {
		return "admin/all-products";
	}
	
	private void getAllProduct(Model model) {
		model.addAttribute("products", adminService.allProduct());
	}
	// end admin/all-product
	
	// admin/deleteProduct
	@RequestMapping(value = { "/admin/deleteProduct" })
	public String deleteProduct(HttpServletRequest req) {
		adminService.deleteProduct(Long.parseLong(req.getParameter("id")));
		return "redirect:/admin/all-products";
	}
	// end admin/deleteProduct
	
}
