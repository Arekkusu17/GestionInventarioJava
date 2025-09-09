
package com.mycompany.gestioninventariojava.view;

import com.mycompany.gestioninventariojava.model.Inventory;
import com.mycompany.gestioninventariojava.model.Product;

public class InventoryView {
    public void printInventoryDetails(Inventory inventory) {
        System.out.println("\n========== LISTADO DE INVENTARIO ==========");
        if (inventory.getAll().isEmpty()) {
            System.out.println("\n>>> El inventario está vacío.\n");
        } else {
            for (var product : inventory.getAll()) {
                printProduct(product);
                System.out.println("-------------------------------------------");
            }
        }
        System.out.println("===========================================\n");
    }

    public void printProduct(Product product) {
        if (product == null) {
            System.out.println("\n>>> Producto no encontrado.\n");
            return;
        }
        System.out.println("ID:         " + product.getProductId());
        System.out.println("Nombre:     " + product.getProductName());
        System.out.println("Descripción:" + product.getProductDescription());
        System.out.println("Precio:     $" + product.getProductPrice());
        System.out.println("Cantidad:   " + product.getProductQuantity());
    }

    public void printProductList(java.util.List<com.mycompany.gestioninventariojava.model.Product> products) {
        if (products == null || products.isEmpty()) {
            System.out.println("\n>>> No se encontraron productos.\n");
            return;
        }
        System.out.println("\n========== RESULTADO DE BÚSQUEDA ==========");
        for (var product : products) {
            printProduct(product);
            System.out.println("-------------------------------------------");
        }
        System.out.println("===========================================\n");
    }

    public void printSummary(String summary) {
        System.out.println("\n========== RESUMEN DEL INVENTARIO ==========");
        System.out.println(summary);
        System.out.println("============================================\n");
    }
}
