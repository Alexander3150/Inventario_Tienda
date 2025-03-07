import javax.swing.JOptionPane;

public class LstEnlazada {
    private Nodo cabeza = null;
    // Metodo para agregar el producto por lista enlazada
    public void agregarProducto(String nombre, double precio, int cantidad) {
        Producto nuevoProducto = new Producto(nombre, precio, cantidad); // Crear producto, para asignarle valores
        Nodo nuevo = new Nodo(nuevoProducto); // Crear nodo un nuevo nodo con el producto
    
        if (cabeza == null) {
            cabeza = nuevo;
            JOptionPane.showMessageDialog(null, "Producto agregado.");
        } else {
            nuevo.siguiente = cabeza; // El nodo que le sigue al nuevo nodo obtiene el valor de la cabeza actual
            cabeza = nuevo; //Actualización de cabeza con el nuevo nodo.
        }
    }
    public void mostrarLista() {
        if (cabeza == null) {
            JOptionPane.showMessageDialog(null, "No hay productos en la lista.");
            return;
        }
        //El  StringBuilder es una cadena que se puede modificar de manera eficiente
        StringBuilder mensaje = new StringBuilder("Lista de Productos:\n");

        Nodo actual = cabeza;
        while (actual != null) {
            mensaje.append("Nombre: ").append(actual.producto.getNombre()) // append concatena 
                    .append("\nPrecio: ").append(actual.producto.getPrecio())
                    .append("\nCantidad: ").append(actual.producto.getCantidad())
                    .append("\n--------------------\n");

            actual = actual.siguiente;
        }

        JOptionPane.showMessageDialog(null, mensaje.toString(), "Productos en Inventario", JOptionPane.INFORMATION_MESSAGE);
    }
    // metodo para actualizar las existencias de un producto por medio de su nombre.
    public void actualizarStock (String nombre, int cantidad)
    {
        Nodo actual = cabeza;

        while (actual != null) 
        {
            if(actual.producto.getNombre().equals(nombre))
            {
                actual.producto.setCantidad(cantidad);
                JOptionPane.showInternalMessageDialog(null, "Stock actualizado para: "+nombre+ "\n Nueva cantidad: "+ cantidad);
                return;
            }
            actual = actual.siguiente;
        }
        JOptionPane.showMessageDialog(null,"Producto no encontrado en la lista.");
    }
    // Metodo para eliminar productos obsoletos cuando su cantidad es igual a 0
    public void eliminarObsoletos() {
        if (cabeza == null) {
            JOptionPane.showMessageDialog(null, "La lista está vacía.");
            return;
        }
    
        String cadena = "Productos eliminados: ";
    
        // Eliminar nodos al inicio si tienen cantidad 0
        while (cabeza != null && cabeza.producto.getCantidad() == 0) {
            cadena += cabeza.producto.getNombre() + " ,";
            cabeza = cabeza.siguiente;
        }
    
        // Si después de eliminar el inicio la lista queda vacía
        if (cabeza == null) {
            JOptionPane.showMessageDialog(null, cadena + "\nTodos los productos obsoletos han sido eliminados.");
            return;
        }
    
        Nodo actual = cabeza;
        while (actual.siguiente != null) {
            if (actual.siguiente.producto.getCantidad() == 0) {
                cadena += actual.siguiente.producto.getNombre() + " ";
                actual.siguiente = actual.siguiente.siguiente;
            } else {
                actual = actual.siguiente;
            }
        }
    
        JOptionPane.showMessageDialog(null, cadena + "\nProductos obsoletos eliminados.");
        mostrarLista();
    }
    

    //Eliminar producto por nombre 
    public void eliminarProducto(String nombre) {
        if (cabeza == null) {
            JOptionPane.showMessageDialog(null, "La lista está vacía.");
            return;
        }
    
        // Si el producto a eliminar está en la cabeza
        if (cabeza.producto.getNombre().equals(nombre)) {
            cabeza = cabeza.siguiente;
            JOptionPane.showMessageDialog(null, "El producto fue eliminado.");
            return;
        }
    
        Nodo actual = cabeza;
        Nodo anterior = null;
    
        // Buscar el producto en la lista
        while (actual != null && !actual.producto.getNombre().equals(nombre)) {
            anterior = actual;
            actual = actual.siguiente;
        }
    
        // Si no se encontró el producto
        if (actual == null) {
            JOptionPane.showMessageDialog(null, "No se encontró el producto a eliminar.");
            return;
        }
    
        // Eliminar el nodo
        anterior.siguiente = actual.siguiente;
        JOptionPane.showMessageDialog(null, "El producto fue eliminado.");
    }    
}
