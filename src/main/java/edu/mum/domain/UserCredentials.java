package edu.mum.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity(name = "CREDENTIALS")
public class UserCredentials implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userCredentials_id;

	@Column(nullable = false, unique = true)
	@NotEmpty

	String username;
	@Column(nullable = false)
	@NotEmpty
	@Size(min = 8)
	String password;
	@Transient
	String verifyPassword;
	// @Transient
	Boolean enabled;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "userid")
	List<Authority> authority = new ArrayList<Authority>();

	@OneToOne(mappedBy = "userCredentials", fetch = FetchType.EAGER)
	User user;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Authority> authorities;

	// @OneToOne(mappedBy = )

	public int getUserCredentials_id() {
		return userCredentials_id;
	}

	public void setUserCredentials_id(int userCredentials_id) {
		this.userCredentials_id = userCredentials_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getVerifyPassword() {
		return verifyPassword;
	}

	public void setVerifyPassword(String verifyPassword) {
		this.verifyPassword = verifyPassword;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public List<Authority> getAuthority() {
		return authority;
	}

	public void setAuthority(List<Authority> authority) {
		this.authority = authority;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
