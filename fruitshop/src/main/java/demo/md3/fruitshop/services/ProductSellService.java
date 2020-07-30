package demo.md3.fruitshop.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.md3.fruitshop.entities.BasketProduct;
import demo.md3.fruitshop.entities.Product;
import demo.md3.fruitshop.entities.ProductSell;
import demo.md3.fruitshop.entities.Sell;
import demo.md3.fruitshop.exception.AppException;
import demo.md3.fruitshop.payload.auth.ApiResponse;
import demo.md3.fruitshop.payload.productsell.SaveProductSellRequest;
import demo.md3.fruitshop.payload.productsell.SaveProductSellResponse;
import demo.md3.fruitshop.repositories.ProductRepository;
import demo.md3.fruitshop.repositories.ProductSellRepository;
import demo.md3.fruitshop.repositories.SellRepository;

@Service
public class ProductSellService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private SellRepository sellRepository;

	@Autowired
	private ProductSellRepository productSellRepository;

	public SaveProductSellResponse saveProductSell(SaveProductSellRequest saveProductSellRequest) {

		List<BasketProduct> basketProducts = saveProductSellRequest.getBasketProducts();
		BigDecimal count = BigDecimal.ZERO;

		for (BasketProduct basketProduct : basketProducts) {
			Product product = basketProduct.getProduct();

			if (product.getQuantity().compareTo(basketProduct.getQuantity()) < 0) {
				throw new AppException("Not enough product!");
			} else {
				product.setQuantity(product.getQuantity().subtract(basketProduct.getQuantity()));
			}
			productRepository.saveAndFlush(product);
			count = count.add(basketProduct.getProduct().getPrice().multiply(basketProduct.getQuantity()));
		}

		Sell sell = new Sell(count);
		sell.setActive(true);

		sellRepository.save(sell);

		List<ProductSell> productSellList = new ArrayList<>();

		for (BasketProduct basketProduct : basketProducts) {
			ProductSell productSell = new ProductSell(basketProduct.getProduct(), basketProduct.getQuantity(), sell);
			sell.setActive(true);
			productSellList.add(productSellRepository.saveAndFlush(productSell));
		}

		return new SaveProductSellResponse(new ApiResponse(true, "Sell created"), productSellList);
	}
}
