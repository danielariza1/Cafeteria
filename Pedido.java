import java.util.LinkedList;
import java.util.Queue;
class Pedido {
    private String nombreCliente;
    private LinkedList<Producto> productos;

    public Pedido(String nombreCliente) {
        this.nombreCliente = nombreCliente;
        this.productos = new LinkedList<>();
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public LinkedList<Producto> getProductos() {
        return productos;
    }

    @Override
    public String toString() {
        StringBuilder detalle = new StringBuilder();
        detalle.append("Cliente: ").append(nombreCliente).append("\n");
        for (Producto producto : productos) {
            detalle.append("  - ").append(producto).append("\n");
        }
        return detalle.toString();
    }
}
