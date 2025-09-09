package com.mycompany.gestioninventariojava.model;

/**
 * Represents a product stored in the inventory.
 * Contains basic information such as id, name, description, price, and quantity in stock.
 */
public class Product {
    private int id;
    private String name;
    private String description;
    private double price;
    private int quantity;

    public Product(int id, String name, String description, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    public int getProductId() {
        return id;
    }

    public void setProductId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return name;
    }

    public void setProductName(String name) {
        this.name = name;
    }

    public String getProductDescription() {
        return description;
    }

    public void setProductDescription(String description) {
        this.description = description;
    }

    public double getProductPrice() {
        return price;
    }

    public void setProductPrice(double price) {
        this.price = price;
    }

    public int getProductQuantity() {
        return quantity;
    }

    public void setProductQuantity(int quantity) {
        this.quantity = quantity;
    }
}
