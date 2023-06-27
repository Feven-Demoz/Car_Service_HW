package com.laba.solvd.service;
import com.laba.solvd.model.Car;
import com.laba.solvd.model.Customer;
import com.laba.solvd.dao.ICustomerDAO;
import com.laba.solvd.dao.CustomerDAO;
import com.laba.solvd.dao.CarDAO;
import com.laba.solvd.service.CarServiceImpl;
import java.util.List;

public class CustomerServiceImpl implements ICustomerServiceImpl {
    private CustomerDAO customerDAO;
    private CarServiceImpl carServiceImpl;

    public CustomerServiceImpl(CustomerDAO customerDAO, CarServiceImpl carServiceImpl) {
        this.customerDAO = customerDAO;
        this.carServiceImpl = carServiceImpl;
    }

    @Override

    public Customer create(Customer customer) {
        customer.setId(null);
        customerDAO.create(customer);
        return customer;

        }


   private Car createCar(Car car) {
       return car;
   }

    @Override
        public List<Customer> getAll () {
            return customerDAO.getAll();
        }

    @Override
    public void delete(Customer customer) {

    }

    @Override
    public List<Customer> findAll() {
        return null;
    }
}


