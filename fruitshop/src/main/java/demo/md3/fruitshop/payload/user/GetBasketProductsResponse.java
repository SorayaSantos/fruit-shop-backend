package demo.md3.fruitshop.payload.user;

import java.util.List;

import demo.md3.fruitshop.entities.BasketProduct;
import demo.md3.fruitshop.payload.auth.ApiResponse;

public class GetBasketProductsResponse {

	private ApiResponse apiResponse;

	private List<BasketProduct> basketProducts;

	public GetBasketProductsResponse() {
	}

	public GetBasketProductsResponse(ApiResponse apiResponse, List<BasketProduct> basketProducts) {
		this.apiResponse = apiResponse;
		this.basketProducts = basketProducts;
	}

	public ApiResponse getApiResponse() {
		return apiResponse;
	}

	public List<BasketProduct> getBasketProducts() {
		return basketProducts;
	}

	public void setApiResponse(ApiResponse apiResponse) {
		this.apiResponse = apiResponse;
	}

	public void setBasketProducts(List<BasketProduct> basketProducts) {
		this.basketProducts = basketProducts;
	}

}
