package edu.mum.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

@Entity
public class Address implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int address_id;
	
	@NotEmpty
	private String street;

	@NotEmpty
	private String city;

	@NotEmpty
	private String state;

	@NotEmpty
	@Size(min = 5, max = 5, message = "{Size.name.validation}")
	//@Range(min=1, max=100000)
	@Pattern(regexp="[0-9]+", message="Wrong zip!")
	private String zipcode;

	public int getAddressId() {
		return address_id;
	}

	public void setAddressId(int address_id) {
		this.address_id = address_id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}


}

