package com.inventario.model;

// Clase que representa un producto en el inventario.
public class Product {
    // Atributos del producto
    private int id; // Identificador único del producto
    private String name; // Nombre del producto
    private double price; // Precio del producto
    private int quantity; // Cantidad disponible del producto

    // Constructor para inicializar un nuevo producto con sus atributos
    public Product(int id, String name, double price, int quantity) {
        this.id = id; // Asigna el ID al atributo de la clase
        this.name = name; // Asigna el nombre al atributo de la clase
        this.price = price; // Asigna el precio al atributo de la clase
        this.quantity = quantity; // Asigna la cantidad al atributo de la clase
    }

    // Método para obtener el ID del producto
    public int getId() {
        return id; // Retorna el ID del producto
    }

    // Método para establecer un nuevo ID al producto
    public void setId(int id) {
        this.id = id; // Actualiza el ID del producto
    }

    // Método para obtener el nombre del producto
    public String getName() {
        return name; // Retorna el nombre del producto
    }

    // Método para establecer un nuevo nombre al producto
    public void setName(String name) {
        this.name = name; // Actualiza el nombre del producto
    }

    // Método para obtener el precio del producto
    public double getPrice() {
        return price; // Retorna el precio del producto
    }

    // Método para establecer un nuevo precio al producto
    public void setPrice(double price) {
        this.price = price; // Actualiza el precio del producto
    }

    // Método para obtener la cantidad del producto
    public int getQuantity() {
        return quantity; // Retorna la cantidad del producto
    }

    // Método para establecer una nueva cantidad al producto
    public void setQuantity(int quantity) {
        this.quantity = quantity; // Actualiza la cantidad del producto
    }
}

