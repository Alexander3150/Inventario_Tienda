import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) throws Exception {
        LstEnlazada lista = new LstEnlazada();
        //Cadena de texto que despues se ajusta en el JoptionPane
            String opciones = "  --- Bienvenidos --- \n\n 1. Agregar Producto\n 2. Mostrar Productos\n 3. Eliminar Productos Obsoletos\n 4. Eliminar Producto\n 5. Actualizar Stock\n 6. Salir";
        int opcion;

        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, opciones, " ----- Menú de Inventario -----", JOptionPane.PLAIN_MESSAGE));

            switch (opcion) {
                case 1:
                    String nombre = JOptionPane.showInputDialog(" - Ingrese el nombre del producto:");
                    double precio = Double.parseDouble(JOptionPane.showInputDialog(" - Ingrese el precio del producto:"));
                    int cantidad = Integer.parseInt(JOptionPane.showInputDialog(" - Ingrese la cantidad del producto:"));
                    lista.agregarProducto(nombre, precio, cantidad);
                    break;
                case 2:
                    lista.mostrarLista();
                    break;
                case 3:
                    lista.eliminarObsoletos();
                    break;
                case 4:
                    String nombreEliminar = JOptionPane.showInputDialog(" - Ingrese el nombre del producto a eliminar:");
                    lista.eliminarProducto(nombreEliminar);
                    break;
                    case 5:
                    String nombreActualizar = JOptionPane.showInputDialog(" - Ingrese el nombre del producto a actualizar stock:");
                    int cantidadActualizada = Integer.parseInt(JOptionPane.showInputDialog(" - Ingrese la cantidad del producto:"));
                    lista.actualizarStock(nombreActualizar, cantidadActualizada);
                    break;
                case 6:
                    JOptionPane.showMessageDialog(null, " ... Saliendo del programa ...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, " +°_°+ Opción inválida. Intente de nuevo.");
            }
        } while (opcion != 6);
    }

    }

