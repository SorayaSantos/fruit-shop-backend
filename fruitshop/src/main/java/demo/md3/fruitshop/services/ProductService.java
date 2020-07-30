package demo.md3.fruitshop.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import demo.md3.fruitshop.entities.Product;
import demo.md3.fruitshop.exception.AppException;
import demo.md3.fruitshop.payload.auth.ApiResponse;
import demo.md3.fruitshop.payload.product.DeleteProductRequest;
import demo.md3.fruitshop.payload.product.DeleteProductResponse;
import demo.md3.fruitshop.payload.product.SaveProductRequest;
import demo.md3.fruitshop.payload.product.SaveProductResponse;
import demo.md3.fruitshop.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public ResponseEntity<List<Product>> getAllProducts() {
		List<Product> products = productRepository.findAll().stream().filter(p -> p.getActive() == true)
				.collect(Collectors.toList());
		return new ResponseEntity<List<Product>>(products, HttpStatus.ACCEPTED);
	}

	public SaveProductResponse saveProduct(SaveProductRequest saveProductRequest) {

		Product product = saveProductRequest.getProduct();
		product.setActive(true);

		productRepository.saveAndFlush(product);

		return new SaveProductResponse(new ApiResponse(true, "Product created"), product);
	}

	public DeleteProductResponse deleteProduct(DeleteProductRequest deleteProductRequest) {

		Product product = productRepository.findById(deleteProductRequest.getId())
				.orElseThrow(() -> new AppException("Product not found"));

		product.setActive(false);
		productRepository.saveAndFlush(product);

		return new DeleteProductResponse(new ApiResponse(true, "Product deleted"));
	}
}
