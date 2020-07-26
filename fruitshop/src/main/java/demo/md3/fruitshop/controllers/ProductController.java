package demo.md3.fruitshop.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/product")
public class ProductController {

	@GetMapping("/test")
	public void testApp() {
		System.out.print("test");
	}
}
