package edu.mum.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Login {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int authentication_id;
	
	@NotEmpty
	private String username;

	@NotEmpty
	@Size(min = 8, max = 50, message = "{Size.name.validation}")
	private String password;

	
	/*public int getId() {
		return authentication_id;
	}

	public void setId(int authentication_id) {
		this.authentication_id = authentication_id;
	}*/
	
	

	public String getUsername() {
		return username;
	}

	public int getAuthentication_id() {
		return authentication_id;
	}

	public void setAuthentication_id(int authentication_id) {
		this.authentication_id = authentication_id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setUserName(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
}
