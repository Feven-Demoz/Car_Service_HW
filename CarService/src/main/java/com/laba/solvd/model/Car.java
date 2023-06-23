package com.laba.solvd.model;
import java.util.List;
import java.util.Objects;

public class Car {
    private int id;
    private String licensePlate;
    private String make;
    private int year;
    private Warranty warranty;
    private List<ServiceRecord> serviceRecordList;

    public Car(int id, String licensePlate, String make, int year, Warranty warranty, List<ServiceRecord> serviceRecordList) {
        this.id = id;
        this.licensePlate = licensePlate;
        this.make = make;
        this.year = year;
        this.warranty = warranty;
        this.serviceRecordList = serviceRecordList;
    }

    public Car () {

   }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Warranty getWarranty() {
        return warranty;
    }

    public void setWarranty(Warranty warranty) {
        this.warranty = warranty;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<ServiceRecord> getServiceRecordList() {
        return serviceRecordList;
    }

    public void setServiceRecordList(List<ServiceRecord> serviceRecordList) {
        this.serviceRecordList = serviceRecordList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return getId() == car.getId() && getYear() == car.getYear() && Objects.equals(getLicensePlate(), car.getLicensePlate()) && Objects.equals(getMake(), car.getMake()) && Objects.equals(getWarranty(), car.getWarranty()) && Objects.equals(getServiceRecordList(), car.getServiceRecordList());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getLicensePlate(), getMake(), getYear(), getWarranty(), getServiceRecordList());
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", licensePlate='" + licensePlate + '\'' +
                ", make='" + make + '\'' +
                ", year=" + year +
                ", warranty=" + warranty +
                ", serviceRecordList=" + serviceRecordList +
                '}';
    }
}
