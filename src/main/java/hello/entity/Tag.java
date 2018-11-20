package hello.entity;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="user_tag")
public class Tag {
	
	@Id
	private String id;
	private String name;
	private long expiary;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id",nullable = false)
	private User user;
	
	public Tag() {
		setId(UUID.randomUUID().toString());
	}

	public Tag(String name, long expiary) {
		this();
		this.name=name;
		this.expiary=expiary;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getExpiary() {
		return expiary;
	}

	public void setExpiary(long expiary) {
		this.expiary = expiary;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Tag [id=" + id + ", name=" + name + ", expiary=" + expiary + ", user=" + user + "]";
	}
	
	
}
