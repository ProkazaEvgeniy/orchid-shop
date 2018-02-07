package net.www.orchid.form;

import java.math.BigDecimal;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import net.www.orchid.entity.Category;
import net.www.orchid.entity.Lenght;
import net.www.orchid.entity.Producer;

public class ProductForm {

	private String photo;
	private String name;
	private BigDecimal price;
	private Integer count;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_lenght")
	private Lenght lenght;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_producer", nullable = false)
	private Producer producer;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_category", nullable = false)
	private Category category;
	private String description;

	public ProductForm() {
		super();
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Lenght getLenght() {
		return lenght;
	}

	public void setLenght(Lenght lenght) {
		this.lenght = lenght;
	}

	public Producer getProducer() {
		return producer;
	}

	public void setProducer(Producer producer) {
		this.producer = producer;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Transient
	public String getProductPhoto() {
		if (photo != null) {
			return photo;
		} else {
			return "/static/img/product-placeholder.png";
		}
	}
}
