package demo.md3.fruitshop.payload.sell;

import java.util.List;

import demo.md3.fruitshop.entities.Sell;
import demo.md3.fruitshop.payload.auth.ApiResponse;

public class GetAllSellsResponse {

	private ApiResponse apiResponse;

	private List<Sell> sells;

	public GetAllSellsResponse() {
	}

	public GetAllSellsResponse(ApiResponse apiResponse, List<Sell> sells) {
		this.apiResponse = apiResponse;
		this.sells = sells;
	}

	public ApiResponse getApiResponse() {
		return apiResponse;
	}

	public List<Sell> getSells() {
		return sells;
	}

	public void setApiResponse(ApiResponse apiResponse) {
		this.apiResponse = apiResponse;
	}

	public void setSells(List<Sell> sells) {
		this.sells = sells;
	}

}
