package hello.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import hello.entity.Tag;

public interface TagDao extends JpaRepository<Tag, String> {
	Tag findByid(String id);
}
