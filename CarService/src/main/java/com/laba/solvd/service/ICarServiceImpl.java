package com.laba.solvd.service;
import com.laba.solvd.model.Car;
import java.util.List;

public interface ICarServiceImpl {
    Car create(Car car);

//    List<Car> getAll();
    void update(Car car);
    Car getById(int id);
    //void delete(Car car);
}