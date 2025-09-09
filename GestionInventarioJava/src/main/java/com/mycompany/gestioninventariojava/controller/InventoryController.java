package com.mycompany.gestioninventariojava.controller;

import com.mycompany.gestioninventariojava.model.Inventory;
import com.mycompany.gestioninventariojava.model.Product;
import com.mycompany.gestioninventariojava.view.InventoryView;

public class InventoryController {
    private Inventory inventory;
    private InventoryView view;

    public InventoryController(Inventory inventory, InventoryView view) {
        this.inventory = inventory;
        this.view = view;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void addProduct(Product product) {
        inventory.add(product);
    }

    public void removeProductById(int id) {
        inventory.removeById(id);
    }

    public void showInventory() {
        view.printInventoryDetails(inventory);
    }

    public void searchProductById(int id) {
        Product product = inventory.findById(id);
        view.printProduct(product);
    }

    public void searchProductByName(String name) {
        view.printProductList(inventory.findByName(name));
    }

    public void showLowStock(int threshold) {
        view.printProductList(inventory.getLowStock(threshold));
    }

    public void showSummary() {
        view.printSummary(inventory.getSummary());
    }
}
