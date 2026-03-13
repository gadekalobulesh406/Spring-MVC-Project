package com.itkedu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itkedu.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
