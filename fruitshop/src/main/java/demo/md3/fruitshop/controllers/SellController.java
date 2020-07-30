package demo.md3.fruitshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.md3.fruitshop.payload.sell.GetAllSellsResponse;
import demo.md3.fruitshop.services.SellService;

@RestController
@RequestMapping("/api/sell")
public class SellController {

	@Autowired
	private SellService sellService;

	@GetMapping("/all")
	public GetAllSellsResponse getAllProducts() {
		return sellService.getAllSells();
	}
}
