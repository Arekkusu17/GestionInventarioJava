package com.mycompany.gestioninventariojava.view;

import com.mycompany.gestioninventariojava.controller.InventoryController;
import com.mycompany.gestioninventariojava.model.Product;
import com.mycompany.gestioninventariojava.helpers.InputValidator;
import java.util.Scanner;

public class MainMenu {
    private InventoryController controller;
    private Scanner scanner;

    public MainMenu(InventoryController controller) {
        this.controller = controller;
        this.scanner = new Scanner(System.in);
    }

    public void show() {
        int option;
        do {
            System.out.println("\n------------------------------------");
            System.out.println("      MENÚ DE GESTIÓN DE INVENTARIO  ");
            System.out.println("------------------------------------");
            System.out.println("| 1 | Agregar producto");
            System.out.println("| 2 | Eliminar producto");
            System.out.println("| 3 | Buscar producto por ID");
            System.out.println("| 4 | Buscar producto por nombre");
            System.out.println("| 5 | Actualizar producto");
            System.out.println("| 6 | Listar todos los productos");
            System.out.println("| 7 | Mostrar productos con bajo stock");
            System.out.println("| 8 | Mostrar resumen del inventario");
            System.out.println("| 0 | Salir");
            System.out.println("------------------------------------");
            option = InputValidator.getInt(scanner, "Seleccione una opción: ");
            System.out.println("------------------------------------");
            switch (option) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    removeProduct();
                    break;
                case 3:
                    searchById();
                    break;
                case 4:
                    searchByName();
                    break;
                case 5:
                    updateProduct();
                    break;
                case 6:
                    controller.showInventory();
                    break;
                case 7:
                    showLowStock();
                    break;
                case 8:
                    controller.showSummary();
                    break;
                case 0:
                    System.out.println("\n¡Gracias por usar el sistema de inventario!\n");
                    break;
                default:
                    System.out.println("\n>>> Opción inválida. Intente nuevamente.\n");
            }
        } while (option != 0);
    }

    private void updateProduct() {
        int id = InputValidator.getInt(scanner, "Ingrese el ID del producto a actualizar: ");
        Product existing = controller.getInventory().findById(id);
        if (existing == null) {
            System.out.println("\n>>> No se encontró un producto con ese ID.\n");
            return;
        }
        System.out.print("Ingrese el nuevo nombre del producto (actual: " + existing.getProductName() + "): ");
        String name = scanner.nextLine();
        if (name.isEmpty()) name = existing.getProductName();

        System.out.print("Ingrese la nueva descripción del producto (actual: " + existing.getProductDescription() + "): ");
        String description = scanner.nextLine();
        if (description.isEmpty()) description = existing.getProductDescription();

        System.out.print("Ingrese el nuevo precio del producto (actual: " + existing.getProductPrice() + "): ");
        String priceInput = scanner.nextLine();
        double price;
        if (priceInput.isEmpty()) {
            price = existing.getProductPrice();
        } else {
            try {
                price = Double.parseDouble(priceInput);
            } catch (NumberFormatException e) {
                System.out.println("Valor inválido. Se mantiene el precio actual.");
                price = existing.getProductPrice();
            }
        }

        System.out.print("Ingrese la nueva cantidad del producto (actual: " + existing.getProductQuantity() + "): ");
        String quantityInput = scanner.nextLine();
        int quantity;
        if (quantityInput.isEmpty()) {
            quantity = existing.getProductQuantity();
        } else {
            try {
                quantity = Integer.parseInt(quantityInput);
            } catch (NumberFormatException e) {
                System.out.println("Valor inválido. Se mantiene la cantidad actual.");
                quantity = existing.getProductQuantity();
            }
        }

        Product updatedProduct = new Product(id, name, description, price, quantity);
        boolean updated = controller.getInventory().updateProduct(updatedProduct);
        if (updated) {
            System.out.println("\n>>> Producto actualizado correctamente.\n");
        } else {
            System.out.println("\n>>> No se encontró un producto con ese ID.\n");
        }
    }

    private void addProduct() {
    String name = InputValidator.getAlphaString(scanner, "Ingrese el nombre del producto: ");
    String description = InputValidator.getAlphaNumericString(scanner, "Ingrese la descripción del producto: ");
        double price = InputValidator.getDouble(scanner, "Ingrese el precio del producto: ");
        int quantity = InputValidator.getInt(scanner, "Ingrese la cantidad del producto: ");
        // El ID será asignado automáticamente por Inventory
        Product product = new Product(0, name, description, price, quantity);
        controller.addProduct(product);
        System.out.println("\n>>> Producto agregado exitosamente.\n");
    }

    private void removeProduct() {
        int id = InputValidator.getInt(scanner, "Ingrese el ID del producto a eliminar: ");
        boolean removed = controller.getInventory().removeById(id);
        if (removed) {
            System.out.println("\n>>> Producto eliminado correctamente.\n");
        } else {
            System.out.println("\n>>> No se encontró un producto con ese ID.\n");
        }
    }

    private void searchById() {
    int id = InputValidator.getInt(scanner, "Ingrese el ID del producto a buscar: ");
        controller.searchProductById(id);
    }

    private void searchByName() {
    String name = InputValidator.getNonEmptyString(scanner, "Ingrese el nombre del producto a buscar: ");
        controller.searchProductByName(name);
    }

    private void showLowStock() {
    int threshold = InputValidator.getInt(scanner, "Ingrese el umbral de stock: ");
        controller.showLowStock(threshold);
    }
}
