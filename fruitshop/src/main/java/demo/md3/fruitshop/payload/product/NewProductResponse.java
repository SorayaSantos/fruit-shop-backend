package demo.md3.fruitshop.payload.product;

import demo.md3.fruitshop.entities.Product;
import demo.md3.fruitshop.payload.auth.ApiResponse;

public class NewProductResponse {

	private ApiResponse apiResponse;

	private Product product;

	public NewProductResponse() {
	}

	public NewProductResponse(ApiResponse apiResponse, Product product) {
		this.apiResponse = apiResponse;
		this.product = product;
	}

	public ApiResponse getApiResponse() {
		return apiResponse;
	}

	public Product getProduct() {
		return product;
	}

	public void setApiResponse(ApiResponse apiResponse) {
		this.apiResponse = apiResponse;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}
