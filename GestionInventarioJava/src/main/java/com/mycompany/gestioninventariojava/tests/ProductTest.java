package com.mycompany.gestioninventariojava.tests;

import com.mycompany.gestioninventariojava.model.Product;

public class ProductTest {
    public static void main(String[] args) {
        System.out.println("=== Pruebas unitarias para Product ===");
        Product p = new Product(1, "Manzana", "Fruta roja", 500.0, 10);
        System.out.println("ID: " + p.getProductId());
        System.out.println("Nombre: " + p.getProductName());
        System.out.println("Descripción: " + p.getProductDescription());
        System.out.println("Precio: " + p.getProductPrice());
        System.out.println("Cantidad: " + p.getProductQuantity());

        // Prueba setters
        p.setProductName("Pera");
        p.setProductDescription("Fruta verde");
        p.setProductPrice(600.0);
        p.setProductQuantity(20);
        System.out.println("\nTras modificar:");
        System.out.println("Nombre: " + p.getProductName());
        System.out.println("Descripción: " + p.getProductDescription());
        System.out.println("Precio: " + p.getProductPrice());
        System.out.println("Cantidad: " + p.getProductQuantity());
    }
}
