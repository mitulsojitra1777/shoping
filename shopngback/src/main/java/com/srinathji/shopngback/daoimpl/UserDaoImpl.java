package com.srinathji.shopngback.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.srinathji.shopngback.dao.UserDao;
import com.srinathji.shopngback.dto.User;

@Repository("userDao")
@Transactional
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean addUser(User user) {
		try {

			sessionFactory.getCurrentSession().persist(user);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;

		}
	}

	@Override
	public boolean updateUser(User user) {
		// update to the database
		try {
			sessionFactory.getCurrentSession().update(user);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteUser(User user) {
		try{
			//update to the database
			user.setEnabled(false);
			sessionFactory.getCurrentSession().update(user);
			return true;
		}catch(Exception ex){
			ex.printStackTrace();
			return false;
			
		}
	}

	@Override
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().get(User.class, Integer.valueOf(id));
	}

	@Override
	public User Login(String uid, String password) {
		// TODO Auto-generated method stub
		String selectActiveCategory = "FROM User WHERE enabled= :active and email :email and password :password";
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
		query.setParameter("active", true);
		query.setParameter("email", uid);
		query.setParameter("password", password);

		return (User) query.getSingleResult();
	}

	@Override
	public List<User> list() {
		String selectActiveCategory = "FROM User WHERE enabled= :active";
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
		query.setParameter("active", true);

		return query.getResultList();
	}

}
