package demo.md3.fruitshop.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.md3.fruitshop.entities.Product;
import demo.md3.fruitshop.payload.product.DeleteProductRequest;
import demo.md3.fruitshop.payload.product.DeleteProductResponse;
import demo.md3.fruitshop.payload.product.SaveProductRequest;
import demo.md3.fruitshop.payload.product.SaveProductResponse;
import demo.md3.fruitshop.services.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping("/all")
	public ResponseEntity<List<Product>> getAllProducts() {
		return productService.getAllProducts();
	}

	@PostMapping("/saveproduct")
	public SaveProductResponse saveProduct(@Valid @RequestBody SaveProductRequest saveProductRequest) {
		return productService.saveProduct(saveProductRequest);
	}

	@PostMapping("/deleteproduct")
	public DeleteProductResponse deleteProduct(@Valid @RequestBody DeleteProductRequest deleteProductRequest) {
		return productService.deleteProduct(deleteProductRequest);
	}
}
