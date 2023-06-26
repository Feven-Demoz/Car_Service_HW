package com.laba.solvd.service;

import com.laba.solvd.dao.CarDAO;
import com.laba.solvd.dao.ICarDAO;
import com.laba.solvd.model.Car;
import com.laba.solvd.model.Customer;

import java.util.List;
public class CarServiceImpl implements ICarServiceImpl {
    private CarDAO carDAO;

    public CarServiceImpl(CarDAO carDAO) {
        this.carDAO = carDAO;
    }

    public  Car createCar (Car car) {

        if (car.getMake() == null || car.getMake().isEmpty()) {
            throw new IllegalArgumentException("Car make is required");
        }
        return carDAO.create(car);
        //return CarServiceImpl.create(car);
    }

    @Override
    public Car create(Car car) {
        return null;
    }

    @Override
    public void update(Car car) {

    }

    @Override
    public Car getById(int id) {
        return null;
    }
}



