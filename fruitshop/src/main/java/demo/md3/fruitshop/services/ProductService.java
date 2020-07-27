package demo.md3.fruitshop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import demo.md3.fruitshop.entities.Product;
import demo.md3.fruitshop.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public ResponseEntity<List<Product>> getAllProducts() {
		return new ResponseEntity<List<Product>>(productRepository.findAll(), HttpStatus.ACCEPTED);
	}

}
