package demo.md3.fruitshop.payload.product;

import javax.validation.constraints.NotNull;

import demo.md3.fruitshop.entities.Product;

public class SaveProductRequest {

	@NotNull
	private Product product;

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}
