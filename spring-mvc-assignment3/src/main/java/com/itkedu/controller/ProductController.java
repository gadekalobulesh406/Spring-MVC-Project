package com.itkedu.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itkedu.model.Product;
import com.itkedu.service.ProductService;

import jakarta.validation.Valid;
import tools.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("product")
public class ProductController {

	private ProductService  productService;
	private ObjectMapper objectMapper;
	
	
	public ProductController(ProductService productService, ObjectMapper objectMapper) {
		this.productService = productService;
		this.objectMapper =objectMapper;
	}

	//to create the product using object mapper 
	@PostMapping
	public String createProduct(@RequestBody String json) throws Exception {

	    Product product = objectMapper.readValue(json, Product.class);

	    Product savedProduct = productService.saveProduct(product);

	    return objectMapper.writeValueAsString(savedProduct);
	}
	
	//to get the all created product using object mapper
	@GetMapping("/{allProducts}")
	public String getAllProduct() throws Exception {

	    List<Product> products = productService.getAllProducts();

	    return objectMapper.writeValueAsString(products);
	}
	
	@GetMapping
	public List<Product> getAllProducts(){
		return productService.getAllProducts();
	}
	
	@GetMapping("/{id}")
	public Product getProduct(@PathVariable Long id) {
		
		return productService.getProduct(id);
	}
	
	@PostMapping("/{create}")
	public Product createProduct(@Valid @RequestBody Product product) {
		return productService.saveProduct(product);
	}
	
	@PostMapping("/{id}")
	public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
		
		return productService.updateProduct(id, product);
	}
	
	@DeleteMapping("/{id}")
	public void deleteProduct(@PathVariable Long id) {
		productService.deleteProduct(id);
	}
	
}
