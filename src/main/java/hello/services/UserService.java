package hello.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hello.Iservice.IUserService;
import hello.dao.UserDao;
import hello.entity.Tag;
import hello.entity.User;

@Service
public class UserService implements IUserService{
	
	@Autowired
	UserDao userDao;
	
	@Override
	public String createUser(User user) {
		userDao.save(user);
		return user.getId();
	}
	
	@Override
	public User getUser(String id) {
		return userDao.findByid(id);
	}

	@Override
	public void addTags(User user, Tag tag) {
		user.addTag(tag);
		tag.setUser(user);
		userDao.save(user);
		
	}
	//@Override
	//public List<User> getUsersByTag(String tag) {
//		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory();
//		EntityManager em = EntityManagerFactory.createEntityManager();
//	      Query query = em.createQuery(
//	              "SELECT DISTINCT u FROM User e INNER JOIN e.tags t where t.name='tag1'");
//	      List<User> users  = userDao.findByTag(tag);
//		return users;
//	}

	@Override
	public List<User> getUsersByTag(String tag) {
		// TODO Auto-generated method stub
		return null;
	}
}
