package com.mycompany.gestioninventariojava.view;

import com.mycompany.gestioninventariojava.model.Product;
import java.util.List;

public class ProductView {
    public void printProductDetails(Product product) {
        System.out.println("Product ID: " + product.getProductId());
        System.out.println("Name: " + product.getProductName());
        System.out.println("Quantity: " + product.getProductQuantity());
    }

    public void printProductList(List<Product> products) {
        for (Product product : products) {
            printProductDetails(product);
            System.out.println("-------------------");
        }
    }
}
