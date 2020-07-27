package demo.md3.fruitshop.payload.user;

import javax.validation.constraints.NotNull;

import demo.md3.fruitshop.entities.BasketProduct;

public class AddProductToBasketRequest {

	@NotNull
	private BasketProduct basketProduct;

	public BasketProduct getBasketProduct() {
		return basketProduct;
	}

	public void setBasketProduct(BasketProduct basketProduct) {
		this.basketProduct = basketProduct;
	}

}
