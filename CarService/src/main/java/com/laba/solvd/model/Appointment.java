package com.laba.solvd.model;

import java.util.Date;
import java.util.Objects;

public class Appointment {
    private int id;
    private int carId;
    private Date appointmentDate;
    private String serviceType;


    public Appointment(int id, int carId, Date appointmentDate, String serviceType) {
        this.id = id;
        this.carId = carId;
        this.appointmentDate = appointmentDate;
        this.serviceType = serviceType;
    }

    public Appointment(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Appointment that = (Appointment) o;
        return getId() == that.getId() && getCarId() == that.getCarId() && Objects.equals(getAppointmentDate(), that.getAppointmentDate()) && Objects.equals(getServiceType(), that.getServiceType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCarId(), getAppointmentDate(), getServiceType());
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", carId=" + carId +
                ", appointmentDate=" + appointmentDate +
                ", serviceType='" + serviceType + '\'' +
                '}';
    }
}
