package com.itkedu.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.itkedu.exception.ResourceNotFoundException;
import com.itkedu.model.Product;
import com.itkedu.repository.ProductRepository;

@Service
public class ProductService {

	  private final ProductRepository productRepository;

	    public ProductService(ProductRepository productRepository) {
	        this.productRepository = productRepository;
	    }
	    
	    public List<Product> getAllProducts(){
	    	return productRepository.findAll();
	    }

		public Product getProduct(Long id) {
			
			return productRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("User not found"+ id));
		}

		public Product saveProduct(Product product) {
			
			return productRepository.save(product);
		}

		public Product updateProduct(Long id, Product product) {
			Product existing = getProduct(id);
			existing.setName(product.getName());
			existing.setPrice(product.getPrice());
			existing.setDescription(product.getDescription());
			existing.setQuantityInStock(product.getQuantityInStock());
			return productRepository.save(existing);
		}

		public void deleteProduct(Long id) {
			productRepository.deleteById(id);
			
		}
}
