package hello.Iservice;

import hello.entity.User;

public interface IUserService {

	public String createUser(User user);
	public User getUser(String id) ;
}
