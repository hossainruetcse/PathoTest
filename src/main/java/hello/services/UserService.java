package hello.services;

import org.springframework.beans.factory.annotation.Autowired;

import hello.dao.UserDao;
import hello.entity.User;

public class UserService {
	
	@Autowired
	UserDao userDao;
	
	public String createUser(User user) {
		userDao.save(user);
		return user.getId();
	}
	
	public User getUser(String id) {
		return userDao.findByid(id);
	}
}
