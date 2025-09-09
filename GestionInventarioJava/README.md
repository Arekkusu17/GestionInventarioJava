# Inventory Management System (Java, MVC)

Este proyecto es una aplicación de consola para la gestión de inventario, desarrollada en Java siguiendo el patrón MVC.

## Características principales
- Agregar, actualizar, eliminar y buscar productos.
- Listar todos los productos y generar informes de inventario.
- Validación robusta de datos de entrada.
- Interfaz en español, compatible con NetBeans y terminales estándar.
- Pruebas unitarias simples incluidas (sin frameworks externos).

## Estructura del proyecto
- `model/` — Clases de dominio (`Product`, `Inventory`)
- `controller/` — Lógica de control (`InventoryController`)
- `view/` — Salida por consola (`InventoryView`)
- `helpers/` — Utilidades de validación (`InputValidator`)
- `tests/` — Pruebas unitarias básicas (`InventoryTest`, `ProductTest`)
- `MainMenu.java` — Menú principal de la aplicación
- `GestionInventarioJava.java` — Punto de entrada

## Ejecución
1. Compila el proyecto con tu IDE o desde terminal:
   ```sh
   javac -d target/classes src/main/java/com/mycompany/gestioninventariojava/**/*.java
   ```
2. Ejecuta la aplicación principal:
   ```sh
   java -cp target/classes com.mycompany.gestioninventariojava.GestionInventarioJava
   ```
3. Para ejecutar pruebas unitarias básicas:
   ```sh
   java -cp target/classes com.mycompany.gestioninventariojava.tests.InventoryTest
   java -cp target/classes com.mycompany.gestioninventariojava.tests.ProductTest
   ```

## Créditos
Desarrollado por Alex Fernández Varas.
