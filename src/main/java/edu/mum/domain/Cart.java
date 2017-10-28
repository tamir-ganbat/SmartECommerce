package edu.mum.domain;

import java.io.Serializable;
import java.math.BigDecimal;
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

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class Cart implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private Long id;

	@Column(name = "total")
	private BigDecimal total;

	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "buyerId")
	private User user;

	@OneToMany
	@Fetch(FetchMode.JOIN)
	private List<Product> products;
	
	@OneToMany
	@Fetch(FetchMode.JOIN)
	private List<CartItem> cartItems;

	public Cart() {
		super();
	}

	public Cart(Long id, BigDecimal total, User buyer, List<Product> products) {
		super();
		//this.id = id;
		this.total = total;
		this.user = buyer;
		this.products = products;
	}

	

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Product> getProducts() {
		if(products == null)
			products = new ArrayList<>();
		return products;
	}
	
	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public List<CartItem> getCartItems() {
		if(cartItems == null)
			cartItems = new ArrayList<>();
		return cartItems;
	}

	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
