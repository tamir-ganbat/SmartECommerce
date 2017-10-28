package edu.mum.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.persistence.Id;

@Entity
public class UserOrder implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="cart_Id")
	private Cart cart;
	
	@Valid
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="user_Id")
	private User user;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="payment_Id")
	private Payment payment;
	
	@Valid
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="address_Id")
	private Address shippingDetail;
	
	@Column(name="shipping")
	private BigDecimal shipping;
	
	@Column(name="tax")
	private BigDecimal tax;
	
	@Column(name="orderTotal")
	private BigDecimal orderTotal;
	
	@Column(name="orderDate")
	private Date orderDate;
	
	public UserOrder() {
		super();
		this.shipping = BigDecimal.ZERO;
		this.tax = BigDecimal.ZERO;
	}


	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Address getShippingDetail() {
		return shippingDetail;
	}

	public void setShippingDetail(Address shippingDetail) {
		this.shippingDetail = shippingDetail;
	}

	public BigDecimal getShipping() {
		return shipping;
	}

	public void setShipping(BigDecimal shipping) {
		this.shipping = shipping;
	}

	public BigDecimal getTax() {
		return tax;
	}

	public void setTax(BigDecimal tax) {
		this.tax = tax;
	}

	public BigDecimal getOrderTotal() {
		return orderTotal;
	}

	public void setOrderTotal(BigDecimal orderTotal) {
		this.orderTotal = orderTotal;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

}
