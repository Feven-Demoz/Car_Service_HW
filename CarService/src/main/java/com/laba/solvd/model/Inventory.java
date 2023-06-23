package com.laba.solvd.model;

import java.util.Objects;

public class Inventory {

    private int quantity;

    public Inventory(int quantity) {
        this.quantity = quantity;
    }

    public Inventory(){

    }
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Inventory inventory = (Inventory) o;
        return getQuantity() == inventory.getQuantity();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getQuantity());
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "quantity=" + quantity +
                '}';
    }
}
