package demo.md3.fruitshop.payload.user;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

public class AddProductToBasketRequest {

	@NotNull
	private Long productId;

	@NotNull
	private BigDecimal quantity;

	public Long getProductId() {
		return productId;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

}
