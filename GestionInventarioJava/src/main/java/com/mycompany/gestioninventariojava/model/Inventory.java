package com.mycompany.gestioninventariojava.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Manages a collection of products in the inventory.
 * Provides methods to add, remove, search, and list products.
 */
public class Inventory {
    /** Map of products in the inventory, keyed by product ID. */
    private Map<Integer, Product> products;
    private int nextId = 1;

    /**
     * Constructs an empty inventory.
     */
    public Inventory() {
        this.products = new HashMap<>();
    }

    /**
     * Adds a product to the inventory.
     * @param product the product to add
     */
    public void add(Product product) {
        // Set auto-incremental ID
        try {
            java.lang.reflect.Field idField = Product.class.getDeclaredField("id");
            idField.setAccessible(true);
            idField.setInt(product, nextId);
        } catch (Exception e) {
            throw new RuntimeException("No se pudo asignar el ID al producto", e);
        }
        products.put(nextId, product);
        nextId++;
    }

    /**
     * Updates the information of an existing product by its ID.
     * @param updatedProduct the product with updated information (must have a valid ID)
     * @return true if the product was found and updated, false otherwise
     */
    public boolean updateProduct(Product updatedProduct) {
        int id = updatedProduct.getProductId();
        if (products.containsKey(id)) {
            products.put(id, updatedProduct);
            return true;
        }
        return false;
    }

    /**
     * Removes a product from the inventory by its ID.
     * @param id the ID of the product to remove
     * @return true if the product was removed, false if not found
     */
    public boolean removeById(int id) {
        return products.remove(id) != null;
    }

    /**
     * Finds a product by its ID.
     * @param id the product ID
     * @return the product if found, null otherwise
     */
    public Product findById(int id) {
        return products.get(id);
    }

    /**
     * Finds products by their name (case-insensitive, partial match).
     * @param name the name or part of the name to search for
     * @return a list of matching products
     */
    public List<Product> findByName(String name) {
        List<Product> result = new ArrayList<>();
        for (Product product : products.values()) {
            if (product.getProductName().toLowerCase().contains(name.toLowerCase())) {
                result.add(product);
            }
        }
        return result;
    }

    /**
     * Finds products by their description (case-insensitive, partial match).
     * @param description the description or part of the description to search for
     * @return a list of matching products
     */
    public List<Product> findByDescription(String description) {
        List<Product> result = new ArrayList<>();
        for (Product product : products.values()) {
            if (product.getProductDescription().toLowerCase().contains(description.toLowerCase())) {
                result.add(product);
            }
        }
        return result;
    }

    /**
     * Returns a list of all products in the inventory.
     * @return the list of products
     */
    public List<Product> getAll() {
        return new ArrayList<>(products.values());
    }

    /**
     * Generates a report of products with stock less than or equal to the specified threshold.
     * @param threshold the maximum quantity to consider as low stock
     * @return a list of products with low stock
     */
    public List<Product> getLowStock(int threshold) {
        List<Product> lowStock = new ArrayList<>();
        for (Product product : products.values()) {
            if (product.getProductQuantity() <= threshold) {
                lowStock.add(product);
            }
        }
        return lowStock;
    }

    /**
     * Generates a summary report of the inventory, including total products and total stock value.
     * @return a string with the inventory summary
     */
    public String getSummary() {
        int totalProducts = products.size();
        int totalStock = 0;
        double totalValue = 0;
        double maxPrice = Double.MIN_VALUE;
        double minPrice = Double.MAX_VALUE;
        String maxProduct = "-";
        String minProduct = "-";
        for (Product product : products.values()) {
            double value = product.getProductPrice() * product.getProductQuantity();
            totalValue += value;
            totalStock += product.getProductQuantity();
            if (product.getProductPrice() > maxPrice) {
                maxPrice = product.getProductPrice();
                maxProduct = product.getProductName();
            }
            if (product.getProductPrice() < minPrice) {
                minPrice = product.getProductPrice();
                minProduct = product.getProductName();
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Cantidad de productos distintos: ").append(totalProducts).append("\n");
        sb.append("Cantidad total de unidades en stock: ").append(totalStock).append("\n");
        sb.append("Valor total del inventario: $").append(String.format("%.2f", totalValue)).append("\n");
        if (totalProducts > 0) {
            sb.append("Producto más caro: ").append(maxProduct).append(" ($").append(String.format("%.2f", maxPrice)).append(")\n");
            sb.append("Producto más barato: ").append(minProduct).append(" ($").append(String.format("%.2f", minPrice)).append(")\n");
        }
        return sb.toString();
    }
}
