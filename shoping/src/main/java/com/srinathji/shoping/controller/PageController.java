package com.srinathji.shoping.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.srinathji.shoping.exception.ProductNotFoundException;
import com.srinathji.shopngback.dao.CategoryDao;
import com.srinathji.shopngback.dao.ProductDao;
import com.srinathji.shopngback.dto.Category;
import com.srinathji.shopngback.dto.Product;

@Controller
public class PageController {
    private static final Logger logger=LoggerFactory.getLogger(PageController.class);
	@Autowired
	private CategoryDao categoryDao;
	@Autowired
	private ProductDao productDao;

	@RequestMapping(value = { "/", "/home", "/index" })
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("page", "home");
		logger.info("inside PageController index method -info");
		logger.debug("inside PageController index method -debug");
		mv.addObject("catogeries", categoryDao.list());
		mv.addObject("userClickHome", true);

		return mv;
	}

	@RequestMapping(value = { "/contact" })
	public ModelAndView contact() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("page", "contact");
		mv.addObject("userClickContact", true);
		return mv;
	}

	@RequestMapping(value = { "/show/all/product" })
	public ModelAndView showAllProduct() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("page", "allProdut");
		mv.addObject("catogeries", categoryDao.list());

		mv.addObject("userClickAllProducts", true);

		return mv;
	}

	@RequestMapping(value = { "/about" })
	public ModelAndView about() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("page", "about");
		mv.addObject("userClickAbout", true);
		return mv;
	}

	@RequestMapping(value = { "/show/catogery/{id}/products" })
	public ModelAndView showCategorywiseProduct(@PathVariable("id") int id) {
		Category category = null;
		category = categoryDao.getCategoryById(id);

		ModelAndView mv = new ModelAndView("page");
		
		mv.addObject("page", category.getName());
		mv.addObject("catogeries", categoryDao.list());

		mv.addObject("catogery", category);
		mv.addObject("userClickCategoryProducts", true);
		mv.addObject("catogeryId", id);

		return mv;
	}

	@RequestMapping(value = { "/show/{id}/products" })
	public ModelAndView showProduct(@PathVariable("id") int id) throws ProductNotFoundException {
		Product product = null;
		product = productDao.getProductById(id);
		if(product==null) throw new ProductNotFoundException();
		product.setViews(product.getViews() + 1);
		productDao.updateProduct(product);
		ModelAndView mv = new ModelAndView("page");
		
		mv.addObject("page", product.getName());
		mv.addObject("product", product);
		mv.addObject("userClickShowProducts", true);
		mv.addObject("catogeryId", id);

		return mv;
	}

	@RequestMapping(value = { "/add/{id}/cart" })
	public ModelAndView addToCart(@PathVariable("id") int id) {
		Product product = null;
		product = productDao.getProductById(id);

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("page", "product");
		mv.addObject("page", product.getName());
		mv.addObject("product", product);
		mv.addObject("userClickShowProducts", true);
		mv.addObject("catogeryId", id);
		

		return mv;
	}

	// queary string just Like
	// http://localhost:8080/shoping/testQuery?greeting=how r u
	@RequestMapping(value = { "/testQuery" })
	public ModelAndView testQuery(@RequestParam("greeting") String greeting) {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("page", "testQuery");
		mv.addObject("message", greeting);
		return mv;
	}

	// path variable(clean url)
	// just Like http://localhost:8080/shoping/parhVar/hello
	@RequestMapping(value = { "/parhVar/{greeting}" })
	public ModelAndView parhVar(@PathVariable("greeting") String greeting) {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("page", "testQuery");
		mv.addObject("message", greeting);
		return mv;
	}

}
