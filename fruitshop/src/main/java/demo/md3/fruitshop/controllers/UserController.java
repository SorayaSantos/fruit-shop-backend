package demo.md3.fruitshop.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.md3.fruitshop.payload.user.AddProductToBasketRequest;
import demo.md3.fruitshop.payload.user.AddProductToBasketResponse;
import demo.md3.fruitshop.payload.user.GetBasketProductsResponse;
import demo.md3.fruitshop.services.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/addproductobasket")
	public AddProductToBasketResponse addProductToBasket(
			@Valid @RequestBody AddProductToBasketRequest addProductToBasketRequest) {
		return userService.addProductToBasket(addProductToBasketRequest.getProductId(),
				addProductToBasketRequest.getQuantity());
	}

	@GetMapping("/getbasketproducts")
	public GetBasketProductsResponse getBasketProducts() {
		return userService.getBasketProducts();
	}
}
