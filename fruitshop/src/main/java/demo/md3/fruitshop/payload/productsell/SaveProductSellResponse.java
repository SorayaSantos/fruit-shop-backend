package demo.md3.fruitshop.payload.productsell;

import java.util.List;

import demo.md3.fruitshop.entities.ProductSell;
import demo.md3.fruitshop.payload.auth.ApiResponse;

public class SaveProductSellResponse {

	private ApiResponse apiResponse;

	private List<ProductSell> productSell;

	public SaveProductSellResponse() {
	}

	public SaveProductSellResponse(ApiResponse apiResponse, List<ProductSell> productSell) {
		this.apiResponse = apiResponse;
		this.productSell = productSell;
	}

	public ApiResponse getApiResponse() {
		return apiResponse;
	}

	public List<ProductSell> getProductSell() {
		return productSell;
	}

	public void setApiResponse(ApiResponse apiResponse) {
		this.apiResponse = apiResponse;
	}

	public void setProductSell(List<ProductSell> productSell) {
		this.productSell = productSell;
	}

}
