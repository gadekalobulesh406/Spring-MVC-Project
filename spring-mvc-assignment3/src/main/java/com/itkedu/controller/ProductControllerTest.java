package com.itkedu.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.itkedu.model.Product;
import com.itkedu.service.ProductService;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ProductController.class)
public class ProductControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ProductService productService;

	@Test
	void shouldReturnAllProducts() throws Exception {

		Product product = new Product();
		product.setProductId(1L);
		product.setName("Laptop");

		when(productService.getAll()).thenReturn(List.of(product));

		mockMvc.perform(get("/products")).andExpect(status().isOk()).andExpect(jsonPath("$[0].name").value("Laptop"));
	}
	
	@Test
    void shouldFailWhenInvalidProduct() throws Exception {

        String invalidJson = "{}";

        mockMvc.perform(post("/product")
                .contentType("application/json")
                .content(invalidJson))
                .andExpect(status().isBadRequest());
    }
}
