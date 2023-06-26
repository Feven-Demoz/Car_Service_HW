package com.laba.solvd;


import com.laba.solvd.dao.CarDAO;
import com.laba.solvd.dao.CustomerDAO;
import com.laba.solvd.model.Car;
import com.laba.solvd.model.Customer;
import com.laba.solvd.service.CarServiceImpl;
import com.laba.solvd.service.CustomerServiceImpl;
//import org.apache.log4j.LogManager;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(String.valueOf(Main.class));
    public static void main(String[] args) {

        CustomerDAO customerDAO = new CustomerDAO();
        CarDAO carDAO = new CarDAO();
        CarServiceImpl carServiceImpl = new CarServiceImpl(carDAO);

        CustomerServiceImpl customerService = new CustomerServiceImpl(customerDAO, carServiceImpl);

        Customer customer = new Customer();
        customer.setFirstName("Sam");
        customer.setLastName("Smith");
        customer.setPhoneNumber("303-765-1098");
        customer.setAddress("123 4th Street LA");

        customerService.create(customer);
        System.out.println(customer.getFirstName());

        Car car = new Car();
        car.setId(1);
        car.setLicensePlate("ABC123");
        car.setMake("BMW");
        car.setYear(2023);
        System.out.println(car.getLicensePlate());

    }

    }
