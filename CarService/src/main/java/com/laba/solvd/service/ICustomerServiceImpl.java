package com.laba.solvd.service;
import com.laba.solvd.model.Customer;
import java.util.List;

public interface ICustomerServiceImpl {
        Customer create(Customer customer);

        List<Customer> getAll();

        void delete(Customer customer);
        List<Customer> findAll();
}




