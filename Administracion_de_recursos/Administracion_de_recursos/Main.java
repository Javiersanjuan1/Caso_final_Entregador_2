import java.util.*;

// Clase para representar un recurso en el zoológico
class Recurso {
    protected String nombre;
    protected int cantidad;

    public Recurso(String nombre, int cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    // Método para obtener información sobre el recurso
    public String obtenerInformacion() {
        return "Nombre: " + nombre + ", Cantidad: " + cantidad;
    }

    // Método para restar la cantidad utilizada del recurso
    public void usarCantidad(int cantidadUsada) {
        if (cantidadUsada <= cantidad) {
            cantidad -= cantidadUsada;
        } else {
            System.out.println("No hay suficiente " + nombre + " disponible.");
        }
    }

    // Método para agregar cantidad al recurso
    public void agregarCantidad(int cantidadNueva) {
        cantidad += cantidadNueva;
    }
}

// Clase para representar un pedido de recursos
class Pedido {
    protected Map<Recurso, Integer> items;

    public Pedido() {
        items = new HashMap<>();
    }

    // Método para agregar un recurso al pedido
    public void agregarRecurso(Recurso recurso, int cantidad) {
        items.put(recurso, cantidad);
    }

    // Método para obtener los items del pedido
    public Map<Recurso, Integer> obtenerItems() {
        return items;
    }
}

// Clase para el manejo de inventarios y pedidos
class GestionRecursos {
    protected Map<Recurso, Integer> inventario;
    protected List<Pedido> pedidos;

    public GestionRecursos() {
        inventario = new HashMap<>();
        pedidos = new ArrayList<>();
    }

    // Método para agregar un recurso al inventario
    public void agregarRecurso(Recurso recurso, int cantidad) {
        inventario.put(recurso, cantidad);
    }

    // Método para procesar un pedido
    public void procesarPedido(Pedido pedido) {
        for (Map.Entry<Recurso, Integer> entry : pedido.obtenerItems().entrySet()) {
            Recurso recurso = entry.getKey();
            int cantidadPedida = entry.getValue();
            if (inventario.containsKey(recurso) && inventario.get(recurso) >= cantidadPedida) {
                recurso.usarCantidad(cantidadPedida);
                inventario.put(recurso, inventario.get(recurso) - cantidadPedida);
            } else {
                System.out.println("No hay suficiente " + recurso.nombre + " para completar el pedido.");
            }
        }
        pedidos.add(pedido);
    }

    // Método para mostrar el inventario
    public void mostrarInventario() {
        System.out.println("Inventario:");
        for (Map.Entry<Recurso, Integer> entry : inventario.entrySet()) {
            Recurso recurso = entry.getKey();
            int cantidad = entry.getValue();
            System.out.println(recurso.obtenerInformacion() + ", Disponible: " + cantidad);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Recurso alimento = new Recurso("Alimento", 100);
        Recurso medicina = new Recurso("Medicina", 50);

        GestionRecursos gestionRecursos = new GestionRecursos();

        gestionRecursos.agregarRecurso(alimento, 100);
        gestionRecursos.agregarRecurso(medicina, 50);

        Pedido pedido = new Pedido();
        pedido.agregarRecurso(alimento, 20);
        pedido.agregarRecurso(medicina, 10);
        gestionRecursos.procesarPedido(pedido);


        gestionRecursos.mostrarInventario();
    }
}
