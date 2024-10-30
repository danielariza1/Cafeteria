import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
// Clase principal para gestionar el sistema de pedidos
public class SistemaCafeteria {
    private static Queue<Pedido> colaPedidos = new LinkedList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\nSistema de Gestión de Pedidos en Cafetería awo");
            System.out.println("1. Registrar un pedido");
            System.out.println("2. Atender el próximo pedido");
            System.out.println("3. Ver estado de los pedidos pendientes");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    registrarPedido(scanner);
                    break;
                case 2:
                    atenderPedido();
                    break;
                case 3:
                    mostrarPedidosPendientes();
                    break;
                case 4:
                    System.out.println("Saliendo del sistema. ¡Gracias!");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        } while (opcion != 4);

        scanner.close();
    }

    private static void registrarPedido(Scanner scanner) {
        System.out.print("Ingrese el nombre del cliente: ");
        String nombreCliente = scanner.nextLine();
        Pedido pedido = new Pedido(nombreCliente);

        String continuar;
        do {
            System.out.print("Ingrese el nombre del producto: ");
            String nombreProducto = scanner.nextLine();
            System.out.print("Ingrese la cantidad: ");
            int cantidad = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            Producto producto = new Producto(nombreProducto, cantidad);
            pedido.agregarProducto(producto);

            System.out.print("¿Desea agregar otro producto al pedido? (si/no): ");
            continuar = scanner.nextLine();
        } while (continuar.equalsIgnoreCase("si"));

        colaPedidos.add(pedido);
        System.out.println("Pedido registrado con éxito.");
    }

    private static void atenderPedido() {
        if (colaPedidos.isEmpty()) {
            System.out.println("No hay pedidos pendientes.");
        } else {
            Pedido pedido = colaPedidos.poll();
            System.out.println("Atendiendo pedido:");
            System.out.println(pedido);
        }
    }

    private static void mostrarPedidosPendientes() {
        if (colaPedidos.isEmpty()) {
            System.out.println("No hay pedidos pendientes.");
        } else {
            System.out.println("Pedidos pendientes:");
            for (Pedido pedido : colaPedidos) {
                System.out.println(pedido);
            }
        }
    }
}
