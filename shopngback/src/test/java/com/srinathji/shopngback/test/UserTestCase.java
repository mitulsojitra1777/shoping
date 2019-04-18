package com.srinathji.shopngback.test;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.srinathji.shopngback.dao.CategoryDao;
import com.srinathji.shopngback.dao.UserDao;
import com.srinathji.shopngback.dto.Category;
import com.srinathji.shopngback.dto.User;

public class UserTestCase {
	private static AnnotationConfigApplicationContext context;

	private static UserDao userDao;
	private User user, user1,user2;
	

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.srinathji.shopngback");
		context.refresh();

		userDao = (UserDao) context.getBean("userDao");

	}

	@Test
	public void addcetogery() {
		user=new User("dainik", "patel", "user", true, "999999999", "dainik.patel@galaxy.com", "dainik@123");
		user1=new User("prakash", "vaghashiya", "suplayer", true, "999999999", "prakash.vagashiya@galaxy.com", "prakash@123");
		user2=new User("chetan", "sojitra", "admin", true, "999999999", "chetan.sojitra@galaxy.com", "chetan@123");


		
		Assert.assertEquals("successfully add user0..... ", true, userDao.addUser(user));
		Assert.assertEquals("successfully add user1..... ", true, userDao.addUser(user1));
		Assert.assertEquals("successfully add user2..... ", true, userDao.addUser(user2));
	}

	/*@Test
	public void getCategorybyID() {
		category = categoryDao.getCategoryById(3);
//		Assert.assertEquals("successfully get single catogory  from category table..... ","computer",
//				 category.getName());
		System.out.println(category.getName()+","+category.getImageurl());
		
	}*/
/*	 @Test
	 public void updateetogery(){
		 category = categoryDao.getCategoryById(7);
		 category.setName("bulb");
		 category.setImageurl("bulb.png");
		 category.setDescription("bulb");
		 category.setActive(false);
		 Assert.assertEquals("successfully update category..... ",true,
				 categoryDao.updateCategory(category) );
	 }*/
//	@Test
//	public void getallcat() {
//		
//		Assert.assertEquals("successfully get all catogory  from category table..... ","1",
//				 userDao.list());
//		//System.out.println(category.getName()+","+category.getImageurl());
//		
//	}

}
