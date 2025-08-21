import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// Clase para representar un producto en el pedido
class Producto {
    private String nombre;
    private int cantidad;

    public Producto(String nombre, int cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public String toString() {
        return nombre + " (Cantidad: " + cantidad + ")";
    }
}
