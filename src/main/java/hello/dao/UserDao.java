package hello.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import hello.entity.User;

public interface UserDao extends JpaRepository<User, String> {
	User findByid(String id);


}
