package com.laba.solvd.model;
import java.util.List;
import java.util.Objects;

public class Part {
    private int id;
    private String name;
    private double price;
    private List<Inventory> inventories;

    public Part(int id, String name, double price, List<Inventory> inventories) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.inventories = inventories;
    }

    public Part(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<Inventory> getInventories() {
        return inventories;
    }

    public void setInventories(List<Inventory> inventories) {
        this.inventories = inventories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Part part = (Part) o;
        return getId() == part.getId() && Double.compare(part.getPrice(), getPrice()) == 0 && Objects.equals(getName(), part.getName()) && Objects.equals(getInventories(), part.getInventories());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getPrice(), getInventories());
    }

    @Override
    public String toString() {
        return "Part{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", inventories=" + inventories +
                '}';
    }
}
