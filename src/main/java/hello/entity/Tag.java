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
	private long expiry;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id",nullable = true)
	private User user;
	
	public Tag() {
		setId(UUID.randomUUID().toString());
	}

	public Tag(String name, long expiry) {
		this();
		this.name=name;
		this.expiry=expiry;
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

	public long getExpiry() {
		return expiry;
	}

	public void setExpiry(long expiry) {
		this.expiry = expiry;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Tag [id=" + id + ", name=" + name + ", expiry=" + expiry + ", user=" + user + "]";
	}
	
	
}
