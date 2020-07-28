package demo.md3.fruitshop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import demo.md3.fruitshop.entities.BasketProduct;
import demo.md3.fruitshop.entities.Product;
import demo.md3.fruitshop.entities.User;
import demo.md3.fruitshop.exception.AppException;
import demo.md3.fruitshop.payload.auth.ApiResponse;
import demo.md3.fruitshop.payload.user.AddProductToBasketResponse;
import demo.md3.fruitshop.payload.user.GetBasketProductsResponse;
import demo.md3.fruitshop.repositories.BasketProductRepository;
import demo.md3.fruitshop.repositories.ProductRepository;
import demo.md3.fruitshop.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BasketProductRepository basketProductRepository;

	@Autowired
	private ProductRepository productRepository;

	public AddProductToBasketResponse addProductToBasket(Long productId, Long quantity) {

		Product product = productRepository.findById(productId)
				.orElseThrow(() -> new AppException("Product not found"));

		if (product.getQuantity() < quantity) {
			return new AddProductToBasketResponse(new ApiResponse(false, "Not enough product!"), null);
		}

		UserDetails userDetails = getCurrentUser();

		User user = userRepository.findByUsername(userDetails.getUsername())
				.orElseThrow(() -> new AppException("User not found"));

		BasketProduct basketProduct = new BasketProduct(product, quantity);
		basketProduct.setActive(true);

		BasketProduct basketProductResult = basketProductRepository.saveAndFlush(basketProduct);

		user.getBasketProducts().add(basketProductResult);

		User result = userRepository.saveAndFlush(user);

		return new AddProductToBasketResponse(new ApiResponse(true, "Product added to basket"),
				result.getBasketProducts());

	}

	public GetBasketProductsResponse getBasketProducts() {

		UserDetails userDetails = getCurrentUser();

		User user = userRepository.findByUsername(userDetails.getUsername())
				.orElseThrow(() -> new AppException("User not found"));

		return new GetBasketProductsResponse(new ApiResponse(true, "Success"), user.getBasketProducts());
	}

	private UserDetails getCurrentUser() {

		Object userPrincipal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserDetails userDetails = null;

		if (userPrincipal instanceof UserDetails) {
			userDetails = (UserDetails) userPrincipal;
		}

		if (userDetails != null) {
			return userDetails;
		} else {
			throw new AppException("Current user not found");
		}

	}
}
