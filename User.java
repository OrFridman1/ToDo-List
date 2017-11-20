package il.hit.model;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



/*
 * This class represent the user object.
 * Each member of the class is matches to a column in the users table in the database.
 */

@Entity
@Table(name="users")
public class User implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	@Id 
	@Column(name = "id")
	private long id;
	@Column(name = "userName")
	private String userName;
	@Column(name = "password")
	private String password;
	@Column(name = "email")
	private String email;
	
	public User()
	{}	
	
	public User(String userName,String password,String email)
	{
		this.userName=userName;
		this.password=password;
		this.email=email;
	}	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getId() {
		return id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", password=" + password + ", email=" + email + "]";
	}
	
	
}
