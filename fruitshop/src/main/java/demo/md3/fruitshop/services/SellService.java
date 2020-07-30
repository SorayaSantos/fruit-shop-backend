package demo.md3.fruitshop.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.md3.fruitshop.entities.Sell;
import demo.md3.fruitshop.payload.auth.ApiResponse;
import demo.md3.fruitshop.payload.sell.GetAllSellsResponse;
import demo.md3.fruitshop.repositories.SellRepository;

@Service
public class SellService {

	@Autowired
	private SellRepository sellRepository;

	public GetAllSellsResponse getAllSells() {
		List<Sell> sells = sellRepository.findAll().stream().filter(p -> p.getActive() == true)
				.collect(Collectors.toList());
		return new GetAllSellsResponse(new ApiResponse(true, "Sell saved"), sells);
	}
}
