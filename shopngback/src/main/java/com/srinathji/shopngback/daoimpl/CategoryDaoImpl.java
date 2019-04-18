package com.srinathji.shopngback.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.srinathji.shopngback.dao.CategoryDao;
import com.srinathji.shopngback.dto.Category;

@Repository("categoryDao")
@Transactional
public class CategoryDaoImpl implements CategoryDao {
	
	@Autowired
	private SessionFactory sessionFactory;
//	private static List<Category> categorys = new ArrayList<>();
//
//	static {
//		Category category = new Category();
//		// adding category data
//		category.setId(1);
//		category.setName("mobile");
//		category.setDescription("mobile phones");
//		category.setActive(true);
//		category.setImageurl("categorymob.png");
//		categorys.add(category);
//		category = new Category();
//		category.setId(2);
//		category.setName("tv");
//		category.setDescription("tv");
//		category.setActive(true);
//		category.setImageurl("tv.png");
//		categorys.add(category);
//		category = new Category();
//		category.setId(3);
//		category.setName("swich");
//		category.setDescription("swich");
//		category.setActive(true);
//		category.setImageurl("swich.png");
//		categorys.add(category);
//	}
//
	public List<Category> list() {
		String selectActiveCategory="FROM Category WHERE active= :active";
		Query query=sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
		query.setParameter("active", true);
		
		return query.getResultList();
	}

	/*
	 * get single category based on id
	 * */
	@Override
	public Category getCategoryById(int id) {
		
		return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));
		
	}

	@Override
	public boolean addCategory(Category category) {
		
		try{
			//addcategory to the database
			sessionFactory.getCurrentSession().persist(category);
			return true;
		}catch(Exception ex){
			ex.printStackTrace();
			return false;
			
		}
		
	}

	@Override
	public boolean updateCategory(Category category) {
		try{
			//update to the database
			sessionFactory.getCurrentSession().update(category);
			return true;
		}catch(Exception ex){
			ex.printStackTrace();
			return false;
			
		}
	}

	@Override
	public boolean deleteCategory(Category category) {
		try{
			//update to the database
			category.setActive(false);
			sessionFactory.getCurrentSession().update(category);
			return true;
		}catch(Exception ex){
			ex.printStackTrace();
			return false;
			
		}
	}

}
