package hello.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hello.Iservice.IUserService;
import hello.dao.UserDao;
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
}
