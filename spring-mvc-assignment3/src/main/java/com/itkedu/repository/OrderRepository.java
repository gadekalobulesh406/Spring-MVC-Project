package com.itkedu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itkedu.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
