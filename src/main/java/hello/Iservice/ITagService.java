package hello.Iservice;

import hello.entity.Tag;

public interface ITagService {
	public Tag createTag(String name, long expiry);
}
