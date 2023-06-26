package com.laba.solvd.dao;
import com.laba.solvd.model.Car;
import java.util.List;
public interface ICarDAO {
    void update (Car car);
    Car getById(int id);
     Car create (Car car);
   // List<Car> getAll();
}
