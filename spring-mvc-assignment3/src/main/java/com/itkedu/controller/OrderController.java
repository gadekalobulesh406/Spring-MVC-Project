package com.itkedu.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itkedu.model.Order;
import com.itkedu.service.OrderService;

import tools.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/orders")
public class OrderController {

	private OrderService orderService;
	private ObjectMapper objectMapper;
	
	public OrderController(OrderService orderService, ObjectMapper objectMapper) {
		this.orderService =orderService;
		this.objectMapper = objectMapper;
	}
	
	//To convert object to json using objecMapper
	@PostMapping("/{placeOrder}")
	public String placeOrder(@RequestBody String json) throws Exception {

	    Order order = objectMapper.readValue(json, Order.class);

	    Order savedOrder = orderService.placeOrder(order);

	    return objectMapper.writeValueAsString(savedOrder);
	}
	
	@PostMapping("/{placeOrders}")
	public Order placeOrder(@RequestBody Order order) {
		
		return orderService.placeOrder(order);
	}
	
	@GetMapping("/{id}")
	public Order getOrder(@PathVariable Long id) {
		return orderService.getOrder(id);
	}
}
