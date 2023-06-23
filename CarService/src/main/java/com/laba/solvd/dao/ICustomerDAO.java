package com.laba.solvd.dao;
import com.laba.solvd.model.Customer;

import java.util.List;


public interface ICustomerDAO {
    void create (Customer customer);
    void delete (Customer customer);
    List<Customer> findAll();

    List<Customer> getAll();
}
//public interface ICustomerDAO {
//    void addCustomer(Customer customer);
//    Customer getCustomer(int customerId);
//    void updateCustomer(Customer customer);
//    void deleteCustomer(int customerId);
//}
