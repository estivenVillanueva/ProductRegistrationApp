package com.inventario.model;

import javax.swing.table.AbstractTableModel; // Importa la clase base para modelos de tabla de Swing
import java.util.List; // Importa la interfaz List para manejo de colecciones
import java.util.ArrayList; // Importa la clase ArrayList para crear una lista dinámica

// Clase que representa el modelo de tabla para productos en el inventario, extendiendo AbstractTableModel
public class ProductTableModel extends AbstractTableModel {
    private final List<Product> productList; // Lista que contiene los productos
    private final String[] columnNames = {"ID", "Nombre", "Precio", "Cantidad"}; // Nombres de las columnas

    // Constructor que inicializa la lista de productos
    public ProductTableModel() {
        this.productList = new ArrayList<>(); // Crea una nueva lista vacía
    }

    // Devuelve el número de filas en la tabla, que corresponde al tamaño de productList
    @Override
    public int getRowCount() {
        return productList.size(); // Retorna la cantidad de productos en la lista
    }

    // Devuelve el número de columnas, que es fijo en este caso
    @Override
    public int getColumnCount() {
        return columnNames.length; // Retorna la cantidad de nombres de columna
    }

    // Devuelve el valor en la celda especificada por rowIndex y columnIndex
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Product product = productList.get(rowIndex); // Obtiene el producto correspondiente a la fila
        switch (columnIndex) {
            case 0:
                return product.getId(); // Retorna el ID del producto
            case 1:
                return product.getName(); // Retorna el nombre del producto
            case 2:
                return product.getPrice(); // Retorna el precio del producto
            case 3:
                return product.getQuantity(); // Retorna la cantidad del producto
            default:
                return null; // Devuelve null si el índice de columna es inválido
        }
    }

    // Devuelve el nombre de la columna especificada por el índice
    @Override
    public String getColumnName(int column) {
        return columnNames[column]; // Retorna el nombre de la columna correspondiente
    }

    // Método para añadir un nuevo producto a la lista y notificar a la tabla
    public void addProduct(Product product) {
        productList.add(product); // Añade el producto a la lista
        // Notifica a la tabla que se ha insertado una nueva fila
        fireTableRowsInserted(productList.size() - 1, productList.size() - 1);
    }
}
