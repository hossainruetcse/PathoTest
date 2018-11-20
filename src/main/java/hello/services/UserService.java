package hello.services;

import java.util.List;

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
}
