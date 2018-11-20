package hello.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hello.Iservice.ITagService;
import hello.dao.TagDao;
import hello.entity.Tag;

@Service
public class TagService implements ITagService {

	@Autowired
	TagDao tagDao;
	@Override
	public Tag createTag(String name, long expiry) {
		Tag tag = new Tag(name, expiry);
		//tagDao.save(tag);
		return tag;
	}

}
