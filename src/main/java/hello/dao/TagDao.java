package hello.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hello.entity.Tag;

public interface TagDao extends JpaRepository<Tag, String> {
	
	Tag findByid(String id);
	List<Tag>  findDistinctByNameIn(List<String> names);
}
