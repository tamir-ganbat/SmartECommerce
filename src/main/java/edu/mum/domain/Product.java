package edu.mum.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

@XmlRootElement
@Entity
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@NotEmpty
	@Size(min = 4, max = 300, message = "{Size.Product.name.validation}")
	@Column(name="name")
	private String name;
	
	@NotEmpty
	@Size(min = 4, max = 1000, message = "{Size.Product.description.validation}")
	@Column(name="description")
	private String description;
	
	@NotNull(message = "{NotNull.Product.qty.validation}")
	@Column(name="qty")
	private Integer qty;
	
	@ColumnDefault("0")
	@Column(name="rate")
	private Double rate;
	
	@ColumnDefault("0")
	@Column(name="rateNumber")
	private Integer rateNumber;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
	private List<Review> reviews;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="imageId")
	private List<Image> images;
	
	@Column(name="totalPages")
	private Integer totalPages;
	
	@NotNull(message = "{NotNull.Product.image.validation}")
	@JsonIgnore
	@Transient
	private MultipartFile image;

	@NotEmpty(message = "{NotEmpty.Product.manufacturer.validation}")
	@Size(min=3, max = 100)
	@Column(name="manufacturer")
	private String manufacturer;

	@NotEmpty(message = "{NotEmpty.Product.category.validation}")
	@Column(name="category")
	private String category;
	
	@Column(name="createdDate")
	private LocalDate createdDate;
	
	@Column(name="modifiedDate")
	private LocalDate modifiedDate;
	
	@Column(name="status")
	private String status;
	
	@Min(value = 0, message = "{Min.Product.price.validation}")
	@Digits(integer = 8, fraction = 2, message = "{Digits.Product.price.validation}")
	@NotNull(message = "{NotNull.Product.price.validation}")
	@Column(name="price")
	private double price;
	
	@Transient
	private Long sellerId;
	
	public Product() {
		super();
	}

	public Product(String name, String description, Integer qty,
			String category, String status, double price) {
		super();
		this.name = name;
		this.description = description;
		this.qty = qty;
		this.category = category;
		this.status = status;
		this.price = price;
	}

	public Double getRate() {
		if (rate == null)
			this.rate = 0.0;
		
		return rate;
	}

	public void setRate(Double rate) {
		this.rate = rate;
	}

	public Integer getRateNumber() {
		if (rateNumber == null)
			this.rateNumber = 0;
		
		return rateNumber;
	}

	public void setRateNumber(Integer totalRate) {
		this.rateNumber = totalRate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getQty() {
		return qty;
	}

	public void setQty(Integer qty) {
		this.qty = qty;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDate getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(LocalDate modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getStatus() {
		if (status == null)
			this.status = "active";
		
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@XmlTransient
	public MultipartFile getImage() {
		return image;
	}

	public void setImage(MultipartFile image) {
		this.image = image;
	}

	public Integer getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}
	
	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description=" + description + ", qty=" + qty + ", rate="
				+ rate + ", rateNumber=" + rateNumber + ", reviews=" + reviews + ", images=" + images + ", totalPages="
				+ totalPages + ", image=" + image + ", manufacturer=" + manufacturer + ", category=" + category
				+ ", createdDate=" + createdDate + ", modifiedDate=" + modifiedDate + ", status=" + status + ", price="
				+ price + ", sellerId=" + sellerId + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
}
