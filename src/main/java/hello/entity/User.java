package hello.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.FetchType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
@Table(name="user")
public class User  {
	
	@Id
	private String id;
	private String password;
	private String firstName;
	private String lastName;
	private String fullName;
	
	@Autowired
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	private List<Tag> tags;


	public User() {
		setId(UUID.randomUUID().toString());
		this.tags = new ArrayList();
	}
	public User(String firstName, String lastName, String password) {
		this();
		this.firstName = firstName;
		this.lastName =lastName;
		this.fullName =firstName+ " "+lastName;
		this.password=password;
	}
	
	

	public void setPassword(String password) {
		this.password = password;
	}
	
	@JsonIgnore
	@JsonProperty(value = "password")
	public String getPassword() {
		return password;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	@JsonIgnore
	@JsonProperty(value = "lastName")
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	@JsonIgnore
	@JsonProperty(value = "lastName")
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public List getTags() {
		return tags;
	}
	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", password=" + password + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", fullName=" + fullName + ", tags=" + tags + "]";
	}
		
}
