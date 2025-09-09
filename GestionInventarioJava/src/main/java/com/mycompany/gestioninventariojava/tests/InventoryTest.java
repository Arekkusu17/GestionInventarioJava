package com.mycompany.gestioninventariojava.tests;

import java.util.List;

import com.mycompany.gestioninventariojava.model.Inventory;
import com.mycompany.gestioninventariojava.model.Product;

public class InventoryTest {
    public static void main(String[] args) {
        System.out.println("=== Pruebas unitarias para Inventory ===");
        Inventory inventory = new Inventory();

        // Agregar productos
        Product p1 = new Product(0, "Manzana", "Fruta roja", 500.0, 10);
        Product p2 = new Product(0, "Pera", "Fruta verde", 600.0, 5);
        Product p3 = new Product(0, "Plátano", "Fruta amarilla", 300.0, 20);
        inventory.add(p1);
        inventory.add(p2);
        inventory.add(p3);
        System.out.println("Productos agregados:");
        for (Product prod : inventory.getAll()) {
            System.out.println("- ID: " + prod.getProductId() + ", Nombre: " + prod.getProductName() + ", Descripción: " + prod.getProductDescription() + ", Precio: $" + prod.getProductPrice() + ", Cantidad: " + prod.getProductQuantity());
        }

        // Buscar por ID
        Product toFind = inventory.findById(2);
        System.out.println("Buscar ID 2: " + (toFind != null ? toFind.getProductName() : "No encontrado"));

        // Probar agregar producto nulo
        try {
            inventory.add(null);
            System.out.println("Agregar producto nulo: No se lanzó excepción (posible error de validación)");
        } catch (Exception e) {
            System.out.println("Agregar producto nulo: Excepción capturada -> " + e.getClass().getSimpleName() + ": " + e.getMessage());
        }

        // Buscar por nombre
        List<Product> toFindByName = inventory.findByName("ana");
        System.out.println("Buscar por nombre 'ana': " + toFindByName.size() + " resultado(s)");

        // Intentar eliminar un producto con un ID inexistente
        boolean toRemoveInexistent = inventory.removeById(999);
        System.out.println("Eliminar ID inexistente 999: " + (toRemoveInexistent ? "Éxito (debería ser FALLO)" : "Fallo (correcto)"));

        // Actualizar producto
        Product productToUpdate = new Product(2, "Pera", "Fruta verde jugosa", 650.0, 8);
        boolean updatedOk = inventory.updateProduct(productToUpdate);
        System.out.println("Actualizar ID 2: " + (updatedOk ? "Éxito" : "Fallo"));

        // Eliminar producto
        boolean toRemove = inventory.removeById(1);
        System.out.println("Eliminar ID 1: " + (toRemove ? "Éxito" : "Fallo"));

        // Buscar por nombre que no existe
        List<Product> toFindByInexistentName = inventory.findByName("noexiste");
        System.out.println("Buscar por nombre 'noexiste': " + (toFindByInexistentName.isEmpty() ? "Lista vacía (correcto)" : toFindByInexistentName.size() + " resultado(s) (debería ser 0)"));

        // Resumen
        System.out.println("\nResumen de inventario:\n" + inventory.getSummary());
    }
}
