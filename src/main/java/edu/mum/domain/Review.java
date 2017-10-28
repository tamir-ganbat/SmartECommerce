package edu.mum.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Review implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Size(max = 100)
	@Column(name="title")
	private String title;
	
	@NotEmpty
	@Size(min = 4, max = 1000, message = "{Size.Review.description.validation}")
	@Column(name="description")
	private String description;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="buyerId")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="productId")
	private Product product;
	
	@NotNull(message = "{NotNull.Review.rate.validation}")
	@Column(name="rate")
	private Double rate;

	@Column(name="createdDate")
	private Date createdDate = new Date();
	
	@Column(name="modifiedDate")
	private Date modifiedDate = new Date();

	public Review() {
	}

	public Review(Long id, String title, String description, User user, Product product, Double rate,
			Date createdDate, Date modifiedDate) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.user = user;
		this.product = product;
		this.rate = rate;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Double getRate() {
		return rate;
	}

	public void setRate(Double rate) {
		this.rate = rate;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	@Override
	public String toString() {
		return "Review [id=" + id + ", title=" + title + ", description=" + description + ", user=" + user
				+ ", product=" + product + ", rate=" + rate + ", createdDate=" + createdDate + ", modifiedDate="
				+ modifiedDate + "]";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
