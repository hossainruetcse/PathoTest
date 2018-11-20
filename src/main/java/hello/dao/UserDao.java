package hello.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import hello.entity.Tag;
import hello.entity.User;

public interface UserDao extends JpaRepository<User, String> {
	
	User findByid(String id);

	//@Query("SELECT DISTINCT u FROM User e INNER JOIN e.tags t where t.name=:tag")
	List<User> findDistinctByTagsIn(List<Tag> tag);

}
