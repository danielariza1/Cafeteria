
import java.util.Scanner;

public class pilaVector {
    int[] pila;
    int tope, tamaño;

    // Constructor para inicializar la pila con el tamaño dado
    pilaVector(int tamaño) {
        this.tamaño = tamaño;
        pila = new int[tamaño];
        tope = -1; 
    }

    // Método para apilar o insertar
    void apilar(int valor) {
        if (tope == tamaño - 1) {
            System.out.println("La pila está llena.");
        } else {
            pila[++tope] = valor;
            System.out.println("Elemento apilado: " + valor);
        }
    }

    // Método para desapilar
    int desapilar() {
        if (tope == -1) {
            System.out.println("La pila está vacía.");
            return -1;
        } else {
            int elemento = pila[tope--];
            System.out.println("Elemento desapilado: " + elemento);
            return elemento;
        }
    }

    // Método para obtener el tope de la pila
    int obtenerTope() {
        if (tope == -1) {
            System.out.println("La pila está vacía.");
            return -1;
        } else {
            return pila[tope];
        }
    }

    // Método para mostrar los elementos de la pila
    void mostrarElementos() {
        if (tope == -1) {
            System.out.println("La pila está vacía.");
        } else {
            System.out.print("Elementos en la pila: ");
            for (int i = tope; i >= 0; i--) {
                System.out.print(pila[i] + " ");
            }
            System.out.println();
        }
    }

    // Método para verificar si la pila está vacía
    boolean estaVacia() {
        return tope == -1;
    }

    // Método para verificar si la pila está llena
    boolean estaLlena() {
        return tope == tamaño - 1;
    }

    // Método para obtener el tamaño de la pila
    int obtenerTamano() {
        return tope + 1;
    }

    // Método para vaciar la pila
    void vaciar() {
        tope = -1;
        System.out.println("La pila ha sido vaciada.");
    }

    // Menú interactivo para la pila
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el tamaño máximo de la pila: ");
        int tamaño = scanner.nextInt();
        
        pilaVector pila = new pilaVector(tamaño);
        int opcion;

        do {
            System.out.println("\n--- Menú de Pila ---");
            System.out.println("1. Apilar (Insertar)");
            System.out.println("2. Desapilar");
            System.out.println("3. Obtener Tope");
            System.out.println("4. Mostrar Elementos");
            System.out.println("5. Verificar si la Pila está Vacía");
            System.out.println("6. Verificar si la Pila está Llena");
            System.out.println("7. Obtener Tamaño de la Pila");
            System.out.println("8. Vaciar la Pila");
            System.out.println("9. Salir");
            System.out.print("Seleccione una opción: ");
            
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el elemento a apilar: ");
                    int elemento = scanner.nextInt();
                    pila.apilar(elemento);
                    break;
                case 2:
                    pila.desapilar();
                    break;
                case 3:
                    int tope = pila.obtenerTope();
                    if (tope != -1) {
                        System.out.println("Tope de la pila: " + tope);
                    }
                    break;
                case 4:
                    pila.mostrarElementos();
                    break;
                case 5:
                    if (pila.estaVacia()) {
                        System.out.println("La pila está vacía.");
                    } else {
                        System.out.println("La pila no está vacía.");
                    }
                    break;
                case 6:
                    if (pila.estaLlena()) {
                        System.out.println("La pila está llena.");
                    } else {
                        System.out.println("La pila no está llena.");
                    }
                    break;
                case 7:
                    System.out.println("Tamaño actual de la pila: " + pila.obtenerTamano());
                    break;
                case 8:
                    pila.vaciar();
                    break;
                case 9:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        } while (opcion != 9);

        scanner.close();
    }
}