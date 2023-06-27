package com.laba.solvd.dao;
import com.laba.solvd.dao.configration.ConnectionPool;
import com.laba.solvd.model.Car;
import com.laba.solvd.model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO implements ICustomerDAO {
    private static final ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance();

    private final String sqlAll = "SELECT c.id as customer_id, c.first_name, c.last_name, c.phone_number, c.address, " +
            "ca.id as car_id, ca.license_plate, ca.make, ca.year " +
            "FROM customers c " +
            "LEFT JOIN cars ca ON c.id = ca.customer_id";

    @Override
    public void create(Customer customer) {
        Connection connection = CONNECTION_POOL.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("Insert into customers(firstName, lastName, phoneNumber, address) values(?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, customer.getFirstName());
            preparedStatement.setString(2, customer.getLastName());
            preparedStatement.setString(3, customer.getPhoneNumber());
            preparedStatement.setString(4, customer.getAddress());


            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            while (resultSet.next()) {
                customer.setId(resultSet.getInt("id"));
                preparedStatement = connection.prepareStatement("insert into cars (id,license_plate, make, year) values(?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
                List<Car> carList = customer.getCars();
                PreparedStatement finalPreparedStatement = preparedStatement;
                carList.forEach((car) ->
                        {
                            try {
                                finalPreparedStatement.setInt(1, resultSet.getInt("id"));
                                finalPreparedStatement.setString(2, car.getLicensePlate());
                                finalPreparedStatement.setString(3, car.getMake());
                                finalPreparedStatement.setInt(4, car.getYear());


                            } catch (SQLException e) {
                                throw new RuntimeException(e);
                            }
                        }
                );


                customer.setCars(carList);
                preparedStatement.executeQuery();
                finalPreparedStatement.executeQuery();


            }
        } catch (SQLException e) {
            throw new RuntimeException("Error executing SQL statement", e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
    }



    @Override
    public List<Customer> getAll() {
        Connection connection = CONNECTION_POOL.getConnection();
        List<Customer> customerList = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(sqlAll);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Customer customer = new Customer();
                customer.setId(resultSet.getInt("customer_id"));
                customer.setFirstName(resultSet.getString("customer_first_name"));
                customer.setLastName(resultSet.getString("customer_last_name"));
                customer.setPhoneNumber(resultSet.getString("customer_phone"));
                customer.setAddress(resultSet.getString("customer_address"));
                customerList.add(customer);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error executing SQL statement", e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
        return customerList;
    }
       @Override
       public void delete (Customer customer)   {
           Connection connection = CONNECTION_POOL.getConnection();
           PreparedStatement preparedStatement = null;
           try{
               preparedStatement = connection.prepareStatement("Delete from customer where id = ?");
               preparedStatement.setInt(1, customer.getId());
               preparedStatement.executeUpdate();
           } catch (SQLException e) {
               throw new RuntimeException("Error executing SQL statement ", e);
           } finally {
               CONNECTION_POOL.releaseConnection(connection);
           }
        }

    @Override
    public List<Customer> findAll() {
        return null;
    }
}

