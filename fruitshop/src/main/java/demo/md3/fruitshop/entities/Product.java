package demo.md3.fruitshop.entities;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "product")
public class Product extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@NotNull
	@Column(name = "name")
	private String name;

	@Column(name = "image")
	private String image;

	@Column(name = "description")
	private String description;

	@NotNull
	@Column(name = "price")
	private BigDecimal price;

	@NotNull
	@Column(name = "quantity")
	private Long quantity;

	public Product() {
	}

	public Product(@NotNull String name, String image, String description, @NotNull BigDecimal price,
			@NotNull Long quantity) {
		super();
		this.name = name;
		this.image = image;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDescription() {
		return description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

}
