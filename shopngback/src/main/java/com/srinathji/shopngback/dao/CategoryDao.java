package com.srinathji.shopngback.dao;

import java.util.List;

import com.srinathji.shopngback.dto.Category;

public interface CategoryDao {

	boolean addCategory(Category category);
	boolean updateCategory(Category category);
	boolean deleteCategory(Category category);
	
	List<Category> list();
	Category getCategoryById(int id);
	
	
	
}
