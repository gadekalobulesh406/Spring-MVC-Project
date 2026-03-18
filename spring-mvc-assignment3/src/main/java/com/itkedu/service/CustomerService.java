package com.itkedu.service;


import com.itkedu.model.Customer;
import java.util.List;

public interface CustomerService {

    Customer save(Customer customer);

    List<Customer> getAll();

    Customer getById(Long id);

    void delete(Long id);
}