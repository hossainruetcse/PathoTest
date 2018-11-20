package hello.Iservice;

import java.util.List;

import hello.entity.Tag;
import hello.entity.User;

public interface IUserService {

	public String createUser(User user);
	public User getUser(String id) ;
	public void addTags(User user, Tag tag);
	public List<User> getUsersByTag(String tag);
}
