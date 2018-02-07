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

@Entity
@Table(name = "lenght")
public class Lenght extends AbstractEntity<Integer> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="LENGHT_ID_GENERATOR", sequenceName="seq_lenght", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="LENGHT_ID_GENERATOR")
	private Integer id;

	@SafeHtml
	@NotNull
	private Integer name;

	//bi-directional many-to-one association to Product
	@OneToMany(mappedBy="lenght", fetch=FetchType.EAGER)
	@Transient
	private List<Product> products;

	public Lenght() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getName() {
		return this.name;
	}

	public void setName(Integer name) {
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
		product.setLenght(this);;

		return product;
	}

	public Product removeProduct(Product product) {
		getProducts().remove(product);
		product.setLenght(null);

		return product;
	}

}