package net.www.orchid.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.data.elasticsearch.annotations.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;

import net.www.orchid.annotation.ProductDataFieldGroup;

@Entity
@Table(name = "product")
@Document(indexName = "product")
public class Product extends AbstractEntity<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PRODUCT_ID_GENERATOR", sequenceName="seq_product", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PRODUCT_ID_GENERATOR")
	private Long id;

	@ProductDataFieldGroup
	private Integer count;

	@ProductDataFieldGroup
	private String description;

	//bi-directional many-to-one association to Producer
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_lenght")
	@ProductDataFieldGroup
	@JsonIgnore
	private Lenght lenght;

	@ProductDataFieldGroup
	private String name;

	@JsonIgnore
	private String photo;

	@ProductDataFieldGroup
	private BigDecimal price;

	//bi-directional many-to-one association to Category
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_category", nullable = false)
	@ProductDataFieldGroup
	private Category category;

	//bi-directional many-to-one association to Producer
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_producer", nullable = false)
	@ProductDataFieldGroup
	private Producer producer;

	public Product() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getCount() {
		return this.count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoto() {
		return this.photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Producer getProducer() {
		return this.producer;
	}

	public void setProducer(Producer producer) {
		this.producer = producer;
	}
	
	public Lenght getLenght() {
		return this.lenght;
	}

	public void setLenght(Lenght lenght) {
		this.lenght = lenght;
	}
	
	@Transient
	public String getProductPhoto() {
		if (photo != null) {
			return photo;
		} else {
			return "/static/img/product-placeholder.png";
		}
	}
	
	public void updateProfilePhotos(String photo){
		setPhoto(photo);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((count == null) ? 0 : count.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lenght == null) ? 0 : lenght.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((photo == null) ? 0 : photo.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((producer == null) ? 0 : producer.hashCode());
		return result;
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
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (count == null) {
			if (other.count != null)
				return false;
		} else if (!count.equals(other.count))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lenght == null) {
			if (other.lenght != null)
				return false;
		} else if (!lenght.equals(other.lenght))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (photo == null) {
			if (other.photo != null)
				return false;
		} else if (!photo.equals(other.photo))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (producer == null) {
			if (other.producer != null)
				return false;
		} else if (!producer.equals(other.producer))
			return false;
		return true;
	}

	
}