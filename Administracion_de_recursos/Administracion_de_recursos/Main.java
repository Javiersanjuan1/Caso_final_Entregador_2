import java.util.*;


class Recurso {
    protected String nombre;
    protected int cantidad;

    public Recurso(String nombre, int cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
    }


    public String obtenerInformacion() {
        return "Nombre: " + nombre + ", Cantidad: " + cantidad;
    }

    public void usarCantidad(int cantidadUsada) {
        if (cantidadUsada <= cantidad) {
            cantidad -= cantidadUsada;
        } else {
            System.out.println("No hay suficiente " + nombre + " disponible.");
        }
    }


    public void agregarCantidad(int cantidadNueva) {
        cantidad += cantidadNueva;
    }
}


class Pedido {
    protected Map<Recurso, Integer> items;

    public Pedido() {
        items = new HashMap<>();
    }


    public void agregarRecurso(Recurso recurso, int cantidad) {
        items.put(recurso, cantidad);
    }

    public Map<Recurso, Integer> obtenerItems() {
        return items;
    }
}

class GestionRecursos {
    protected Map<Recurso, Integer> inventario;
    protected List<Pedido> pedidos;

    public GestionRecursos() {
        inventario = new HashMap<>();
        pedidos = new ArrayList<>();
    }

    public void agregarRecurso(Recurso recurso, int cantidad) {
        inventario.put(recurso, cantidad);
    }


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
