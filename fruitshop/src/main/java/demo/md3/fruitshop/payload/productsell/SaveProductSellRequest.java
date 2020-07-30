package demo.md3.fruitshop.payload.productsell;

import java.util.List;

import javax.validation.constraints.NotNull;

import demo.md3.fruitshop.entities.BasketProduct;

public class SaveProductSellRequest {

	@NotNull
	private List<BasketProduct> basketProducts;

	public List<BasketProduct> getBasketProducts() {
		return basketProducts;
	}

	public void setBasketProducts(List<BasketProduct> basketProducts) {
		this.basketProducts = basketProducts;
	}

}
