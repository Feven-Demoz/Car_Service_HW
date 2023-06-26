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
        if (customer.getCars() != null) {
            for (Car car : customer.getCars()) {
               Car createdCar = createCar(car);
                CarDAO.setCar(createdCar, customer);
            }
        }

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

//
//    @Override
//    public void addCustomer(Customer customer) {
//        customerDAO.addCustomer(customer);
//    }
//
//    @Override
//    public Customer getCustomer(int customerId) {
//        return null;
//    }
//    //    @Override
////    public Customer getCustomer(int customerId) {
////        return customerDAO.getCustomer(customerId);
////    }
//
//    @Override
//    public void updateCustomer(Customer customer) {
//        customerDAO.updateCustomer(customer);
//    }
//
//    @Override
//    public void deleteCustomer(int customerId) {
//        customerDAO.deleteCustomer(customerId);
//    }
//}

