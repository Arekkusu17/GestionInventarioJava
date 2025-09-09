/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.gestioninventariojava.app;

import com.mycompany.gestioninventariojava.view.MainMenu;

/**
 *
 * @author arekk
 */
public class GestionInventarioJava {

    public static void main(String[] args) {
    // MVC Boilerplate usage
    // Start Inventory Management Console Menu
    com.mycompany.gestioninventariojava.model.Inventory inventory = new com.mycompany.gestioninventariojava.model.Inventory();
    com.mycompany.gestioninventariojava.view.InventoryView inventoryView = new com.mycompany.gestioninventariojava.view.InventoryView();
    com.mycompany.gestioninventariojava.controller.InventoryController inventoryController = new com.mycompany.gestioninventariojava.controller.InventoryController(inventory, inventoryView);
    MainMenu menu = new MainMenu(inventoryController);
    menu.show();
    }
}
