package demo.md3.fruitshop.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.md3.fruitshop.payload.productsell.SaveProductSellRequest;
import demo.md3.fruitshop.payload.productsell.SaveProductSellResponse;
import demo.md3.fruitshop.services.ProductSellService;

@RestController
@RequestMapping("/api/productsell")
public class ProductSellController {

	@Autowired
	private ProductSellService productSellService;

	@PostMapping("/saveproductsell")
	public SaveProductSellResponse saveProductSell(@Valid @RequestBody SaveProductSellRequest saveProductSellRequest) {
		return productSellService.saveProductSell(saveProductSellRequest);
	}
}
