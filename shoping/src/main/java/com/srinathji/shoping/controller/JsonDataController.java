package com.srinathji.shoping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.srinathji.shopngback.dao.ProductDao;
import com.srinathji.shopngback.dto.Product;

@Controller
@RequestMapping("/json/data")
public class JsonDataController {
	@Autowired
	ProductDao productDao;
	
	@RequestMapping("/all/product")
	@ResponseBody
	public List<Product> getAllProduct(){
		
		return (List<Product>)productDao.list();
	}
	
	@RequestMapping("category/{id}/product")
	@ResponseBody
	public List<Product> categoryProduct(@PathVariable int id){
		
		return (List<Product>)productDao.getCategoryProduct(id);
	}

}
