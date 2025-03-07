public class Nodo {
    Producto producto;
    Nodo siguiente;

    public Nodo(Producto producto) {
        this.producto = producto; // Asignación correcta del objeto Producto, porque pensaba que cuando se realizava un costructor de un objeto se tenia que separar con sus variables como, this.producto.getnombre = nombre o tipo asi, pero no. 
        this.siguiente = null; // El nodo siguiente es inicialmente nulo
    }
}
