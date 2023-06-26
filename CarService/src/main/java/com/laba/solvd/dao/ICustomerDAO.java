package com.laba.solvd.dao;
import com.laba.solvd.model.Customer;

import java.util.List;


public interface ICustomerDAO {
    void create (Customer customer);
    void delete (Customer customer);
    List<Customer> findAll();

    List<Customer> getAll();
}

