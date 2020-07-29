package demo.md3.fruitshop.payload.product;

import demo.md3.fruitshop.entities.Product;
import demo.md3.fruitshop.payload.auth.ApiResponse;

public class SaveProductResponse {

	private ApiResponse apiResponse;

	private Product product;

	public SaveProductResponse() {
	}

	public SaveProductResponse(ApiResponse apiResponse, Product product) {
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
