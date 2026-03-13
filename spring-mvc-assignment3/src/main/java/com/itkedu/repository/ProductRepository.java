package com.itkedu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itkedu.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
