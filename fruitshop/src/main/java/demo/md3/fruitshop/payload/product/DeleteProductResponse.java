package demo.md3.fruitshop.payload.product;

import demo.md3.fruitshop.payload.auth.ApiResponse;

public class DeleteProductResponse {

	private ApiResponse apiResponse;

	public DeleteProductResponse() {
	}

	public DeleteProductResponse(ApiResponse apiResponse) {
		this.apiResponse = apiResponse;
	}

	public ApiResponse getApiResponse() {
		return apiResponse;
	}

	public void setApiResponse(ApiResponse apiResponse) {
		this.apiResponse = apiResponse;
	}

}
