package com.ra.model;

public class Product {
    private String id;
    private String model;
    private String name;
    private double price;
    private boolean status;

    public Product(String id, String model, String name, int price, boolean status) {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void display(){
        System.out.printf("%s | %s | %s | %s | %s\n",getId(),getModel(),getName(),getPrice(),isStatus()?"Đúng":"Sai");
    }
}
