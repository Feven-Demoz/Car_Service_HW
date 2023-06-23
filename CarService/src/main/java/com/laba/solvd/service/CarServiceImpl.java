package com.laba.solvd.service;

import com.laba.solvd.dao.ICarDAO;
import com.laba.solvd.model.Car;

public class CarServiceImpl {
    private ICarDAO CarDAO;

    public CarServiceImpl() {
        ICarDAO carDAO;
        //CarDAO = carDAO;
    }

    public static Car create(Car car) {

        return car;
    }

    public void updateCar(Car car) {
        CarDAO.update(car);
    }

    public Car getCarById(int id) {
        return CarDAO.getById(id);
    }

   // public List<Car> getAllCars() {


      //  return carDAO.getAll();
   // }
}

