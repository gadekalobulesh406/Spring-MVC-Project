package com.itkedu.service;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.itkedu.exception.ResourceNotFoundException;
import com.itkedu.model.Order;
import com.itkedu.model.Product;
import com.itkedu.repository.OrderRepository;

@Service
public class OrderService {

	private OrderRepository orderRepository;
	
	public OrderService(OrderRepository orderRepository) {
		super();
		this.orderRepository = orderRepository;
	}
	public Order placeOrder(Order order) {
		order.setOrderDate(LocalDate.now());
		double total = order.getProducts()
				.stream()
				.mapToDouble(Product :: getPrice)
				.sum();
		order.setTotalPrice(total);
		order.setOrderStatus("Placed");
		
		return orderRepository.save(order);
	}
	public Order getOrder(Long id) {
		
		return orderRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Order not found"+ id));
	}

}
