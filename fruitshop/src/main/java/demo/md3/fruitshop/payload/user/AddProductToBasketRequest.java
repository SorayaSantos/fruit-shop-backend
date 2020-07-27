package demo.md3.fruitshop.payload.user;

import javax.validation.constraints.NotNull;

public class AddProductToBasketRequest {

	@NotNull
	private Long productId;

	@NotNull
	private Long quantity;

	public Long getProductId() {
		return productId;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

}
