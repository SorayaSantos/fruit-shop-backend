package demo.md3.fruitshop.entities;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "product_sell")
public class ProductSell extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;

	@NotNull
	@Column(name = "quantity")
	private BigDecimal quantity;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "sell_id")
	private Sell sell;

	public ProductSell() {
	}

	public ProductSell(@NotNull Product product, @NotNull BigDecimal quantity, @NotNull Sell sell) {
		this.product = product;
		this.quantity = quantity;
		this.sell = sell;
	}

	public Product getProduct() {
		return product;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public Sell getSell() {
		return sell;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public void setSell(Sell sell) {
		this.sell = sell;
	}

}
