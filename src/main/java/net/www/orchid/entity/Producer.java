package net.www.orchid.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.SafeHtml;

import net.www.orchid.annotation.ProducerDataFieldGroup;

@Entity
@Table(name = "producer")
public class Producer extends AbstractEntity<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PRODUCER_ID_GENERATOR", sequenceName="seq_producer", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PRODUCER_ID_GENERATOR")
	private Long id;

	@SafeHtml
	@NotNull
	@ProducerDataFieldGroup
	private String name;

	//bi-directional many-to-one association to Product
	@OneToMany(mappedBy="producer", fetch=FetchType.EAGER)
	@Transient
	private List<Product> products;

	public Producer() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Product> getProducts() {
		return this.products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Product addProduct(Product product) {
		getProducts().add(product);
		product.setProducer(this);

		return product;
	}

	public Product removeProduct(Product product) {
		getProducts().remove(product);
		product.setProducer(null);

		return product;
	}

}