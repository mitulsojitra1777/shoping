package com.srinathji.shoping.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.srinathji.shoping.util.FileUploadUtility;
import com.srinathji.shoping.validator.ProductValidator;
import com.srinathji.shopngback.dao.CategoryDao;
import com.srinathji.shopngback.dao.ProductDao;
import com.srinathji.shopngback.dto.Category;
import com.srinathji.shopngback.dto.Product;

@Controller
@RequestMapping("/manage")
public class ManagementController {

	@Autowired
	CategoryDao categoryDao;

	@Autowired
	ProductDao productDao;

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public ModelAndView showManageProducts(@RequestParam(name="operation" ,required=false)String operation) {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickManageProduct", true);
		mv.addObject("page", "Manage-Products");
		Product nProduct = new Product();
		// set few of the fields
		nProduct.setSuplierid(1);
		nProduct.setActive(true);
		mv.addObject("product", nProduct);
		if(operation!=null){
			if(operation.equals("product")){
				mv.addObject("message", "Product sublation success...");

			}
		}

		return mv;
	}

	// handel product submation
	@RequestMapping(value = "/products", method = RequestMethod.POST)
	public String handleProductSubmation(@Valid @ModelAttribute("product") Product mProduct, BindingResult result,
			Model model, HttpServletRequest request) {
		new ProductValidator().validate(mProduct, result);
		if (result.hasErrors()) {
			model.addAttribute("userClickManageProduct", true);
			model.addAttribute("page", "Manage-Products");
			return "page";
		} else {
			productDao.addProduct(mProduct);
			if(!mProduct.getFile().equals("")){
				FileUploadUtility.uploadFile(request, mProduct.getFile(), mProduct.getCode());
			}
			return "redirect:/manage/products?operation=product";
		}
	}
	
	// returning category list for all request mapping
	@ModelAttribute("categories")
	public List<Category> getCategory() {
		return categoryDao.list();
	}
}
