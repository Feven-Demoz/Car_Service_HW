package com.laba.solvd.dao;

import com.laba.solvd.dao.configration.ConnectionPool;
import com.laba.solvd.model.Car;
import com.laba.solvd.model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CarDAO implements ICarDAO{

    private static final ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance();
    private final String sqlUpdate = "UPDATE cars SET license_plate = ?, make = ?, year = ? WHERE id = ?";
    private final String sqlGetById = "SELECT * FROM cars WHERE id = ?";

    public static void setCar(Car createdCar, Customer customer) {
    }

    //private final String sqlGetAll = "SELECT * FROM cars";
    @Override
    public void update(Car car) {
        Connection connection = CONNECTION_POOL.getConnection();
        PreparedStatement preparedStatement = null;
        try{
            preparedStatement = connection.prepareStatement(sqlUpdate);
            preparedStatement.setString(1, car.getLicensePlate());
            preparedStatement.setString(2, car.getMake());
            preparedStatement.setInt(3, car.getYear());
            preparedStatement.setInt(4, car.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error executing SQL statement", e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);

        }
    }

    @Override
    public Car getById(int id) {
        Connection connection = CONNECTION_POOL.getConnection();
        Car car = null;
        try {
            PreparedStatement statement = connection.prepareStatement(sqlGetById);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                car = new Car();
                car.setId(resultSet.getInt("id"));
                car.setLicensePlate(resultSet.getString("license_plate"));
                car.setMake(resultSet.getString("make"));
                car.setYear(resultSet.getInt("year"));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error executing SQL statement", e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
        return null;
    }

    @Override
    public void create(Car car) {

    }

//    @Override
//    public List<Car> getAll() {
//        return null;
   // }
}
