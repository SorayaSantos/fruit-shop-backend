package demo.md3.fruitshop.entities;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "basket_product")
public class BasketProduct extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;

	@NotNull
	@Column(name = "quantity")
	private BigDecimal quantity;

	public BasketProduct() {
	}

	public BasketProduct(@NotNull Product product, @NotNull BigDecimal quantity) {
		this.product = product;
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

}
