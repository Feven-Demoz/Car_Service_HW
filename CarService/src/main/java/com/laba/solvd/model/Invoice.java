package com.laba.solvd.model;
import java.util.List;
import java.util.Date;
import java.util.Objects;

public class Invoice {
    private int id;
    private double totalAmount;
    private Date date;
    private List<Payment> paymentList;



    public Invoice(int id, double totalAmount, Date date, List<Payment> paymentList) {
        this.id = id;
        this.totalAmount = totalAmount;
        this.date = date;
        this.paymentList = paymentList;
    }

    public Invoice(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    public List<Payment> getPaymentList() {
        return paymentList;
    }

    public void setPaymentList(List<Payment> paymentList) {
        this.paymentList = paymentList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Invoice invoice = (Invoice) o;
        return getId() == invoice.getId() && Double.compare(invoice.getTotalAmount(), getTotalAmount()) == 0 && Objects.equals(getDate(), invoice.getDate()) && Objects.equals(getPaymentList(), invoice.getPaymentList());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTotalAmount(), getDate(), getPaymentList());
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", totalAmount=" + totalAmount +
                ", date=" + date +
                ", paymentList=" + paymentList +
                '}';
    }
}
