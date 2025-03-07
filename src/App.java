import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) throws Exception {
        LstEnlazada lista = new LstEnlazada();
        // Cadena de texto que después se ajusta en el JOptionPane
        String opciones = "  --- Bienvenidos --- \n\n 1. Agregar Producto\n 2. Mostrar Productos\n 3. Eliminar Productos Obsoletos\n 4. Eliminar Producto\n 5. Actualizar Stock\n 6. Salir";
        int opcion;

        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, opciones, " ----- Menú de Inventario -----", JOptionPane.INFORMATION_MESSAGE));

            switch (opcion) {
                case 1:
                    String nombre = JOptionPane.showInputDialog(null, " - Ingrese el nombre del producto:", "Agregar Producto", JOptionPane.QUESTION_MESSAGE);
                    double precio = Double.parseDouble(JOptionPane.showInputDialog(null, " - Ingrese el precio del producto:", "Agregar Producto", JOptionPane.QUESTION_MESSAGE));
                    int cantidad = Integer.parseInt(JOptionPane.showInputDialog(null, " - Ingrese la cantidad del producto:", "Agregar Producto", JOptionPane.QUESTION_MESSAGE));
                    lista.agregarProducto(nombre, precio, cantidad);
                    break;
                case 2:
                    lista.mostrarLista();
                    break;
                case 3:
                    lista.eliminarObsoletos();
                    break;
                case 4:
                    String nombreEliminar = JOptionPane.showInputDialog(null, " - Ingrese el nombre del producto a eliminar:", "Eliminar Producto", JOptionPane.WARNING_MESSAGE);
                    lista.eliminarProducto(nombreEliminar);
                    break;
                case 5:
                    String nombreActualizar = JOptionPane.showInputDialog(null, " - Ingrese el nombre del producto a actualizar stock:", "Actualizar Stock", JOptionPane.QUESTION_MESSAGE);
                    int cantidadActualizada = Integer.parseInt(JOptionPane.showInputDialog(null, " - Ingrese la cantidad del producto:", "Actualizar Stock", JOptionPane.QUESTION_MESSAGE));
                    lista.actualizarStock(nombreActualizar, cantidadActualizada);
                    break;
                case 6:
                    JOptionPane.showMessageDialog(null, " ... Saliendo del programa ...", "Salir", JOptionPane.INFORMATION_MESSAGE);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, " +°_°+ Opción inválida. Intente de nuevo.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } while (opcion != 6);
    }
    }

