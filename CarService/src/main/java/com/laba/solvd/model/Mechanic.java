package com.laba.solvd.model;
import java.util.List;
import java.util.Objects;

public class Mechanic {
    private int id;
    private String firstName;
    private String lastName;
    private int experienceYear;
    private double hourlyRate;

    public Mechanic(int id, String firstName, String lastName, int experienceYear, double hourlyRate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.experienceYear = experienceYear;
        this.hourlyRate = hourlyRate;
    }

    public Mechanic(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getExperienceYear() {
        return experienceYear;
    }

    public void setExperienceYear(int experienceYear) {
        this.experienceYear = experienceYear;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mechanic mechanic = (Mechanic) o;
        return getId() == mechanic.getId() && getExperienceYear() == mechanic.getExperienceYear() && Double.compare(mechanic.getHourlyRate(), getHourlyRate()) == 0 && Objects.equals(getFirstName(), mechanic.getFirstName()) && Objects.equals(getLastName(), mechanic.getLastName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstName(), getLastName(), getExperienceYear(), getHourlyRate());
    }

    @Override
    public String toString() {
        return "Mechanic{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", experienceYear=" + experienceYear +
                ", hourlyRate=" + hourlyRate +
                '}';
    }
}
