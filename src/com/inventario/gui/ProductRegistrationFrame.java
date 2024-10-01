package com.inventario.gui;

import javax.swing.*; // Importa las clases de Swing para crear la interfaz gráfica
import java.awt.*; // Importa clases para diseño de interfaces (layouts, componentes)
import java.awt.event.ActionEvent; // Importa la clase para eventos de acción
import java.awt.event.ActionListener; // Importa la interfaz para manejar eventos de acción
import com.inventario.model.Product; // Importa la clase Product del modelo
import com.inventario.model.ProductTableModel; // Importa el modelo de tabla de productos

// Clase que representa el marco de registro de productos
public class ProductRegistrationFrame extends JFrame {
    // Campos de texto para la entrada de datos del producto
    private JTextField idField, nameField, priceField, quantityField;
    private JButton saveButton; // Botón para guardar el producto
    private JTable productTable; // Tabla para mostrar los productos
    private ProductTableModel tableModel; // Modelo de la tabla

    // Constructor que inicializa el marco
    public ProductRegistrationFrame() {
        setTitle("Registro de Productos"); // Establece el título del marco
        setSize(600, 400); // Establece el tamaño del marco
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cierra la aplicación al cerrar el marco
        setLocationRelativeTo(null); // Centra el marco en la pantalla

        initComponents(); // Llama al método para inicializar componentes
    }

    // Método para inicializar los componentes de la interfaz
    private void initComponents() {
        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10)); // Crea un panel con un layout de cuadrícula

        panel.add(new JLabel("ID:")); // Añade una etiqueta para el ID
        idField = new JTextField(); // Crea un campo de texto para el ID
        panel.add(idField); // Añade el campo al panel

        panel.add(new JLabel("Nombre:")); // Añade una etiqueta para el nombre
        nameField = new JTextField(); // Crea un campo de texto para el nombre
        panel.add(nameField); // Añade el campo al panel

        panel.add(new JLabel("Precio:")); // Añade una etiqueta para el precio
        priceField = new JTextField(); // Crea un campo de texto para el precio
        panel.add(priceField); // Añade el campo al panel

        panel.add(new JLabel("Cantidad:")); // Añade una etiqueta para la cantidad
        quantityField = new JTextField(); // Crea un campo de texto para la cantidad
        panel.add(quantityField); // Añade el campo al panel

        saveButton = new JButton("Guardar"); // Crea un botón para guardar el producto
        panel.add(saveButton); // Añade el botón al panel

        tableModel = new ProductTableModel(); // Inicializa el modelo de la tabla
        productTable = new JTable(tableModel); // Crea la tabla con el modelo

        add(panel, BorderLayout.NORTH); // Añade el panel al borde norte del marco
        add(new JScrollPane(productTable), BorderLayout.CENTER); // Añade la tabla con scroll al centro del marco

        // Añade un ActionListener al botón "Guardar"
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveProduct(); // Llama al método para guardar el producto
            }
        });
    }

    // Método para guardar un nuevo producto
    private void saveProduct() {
        try {
            // Intenta parsear los campos de texto a los tipos correspondientes
            int id = Integer.parseInt(idField.getText());
            String name = nameField.getText();
            double price = Double.parseDouble(priceField.getText());
            int quantity = Integer.parseInt(quantityField.getText());

            // Crea un nuevo objeto Product
            Product product = new Product(id, name, price, quantity);
            tableModel.addProduct(product); // Añade el producto al modelo de la tabla

            clearFields(); // Limpia los campos de texto
        } catch (NumberFormatException ex) {
            // Si hay un error de formato, muestra un mensaje de error
            JOptionPane.showMessageDialog(this, "Por favor, ingrese valores válidos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para limpiar los campos de texto
    private void clearFields() {
        idField.setText(""); // Limpia el campo ID
        nameField.setText(""); // Limpia el campo Nombre
        priceField.setText(""); // Limpia el campo Precio
        quantityField.setText(""); // Limpia el campo Cantidad
    }
}
