import java.util.*;

// Clase para representar una tarea de mantenimiento
class TareaMantenimiento {
    private String descripcion;
    private boolean urgente;

    public TareaMantenimiento(String descripcion, boolean urgente) {
        this.descripcion = descripcion;
        this.urgente = urgente;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public boolean esUrgente() {
        return urgente;
    }
}

// Clase para el sistema de mantenimiento
class SistemaMantenimiento {
    private List<TareaMantenimiento> tareasPendientes;

    public SistemaMantenimiento() {
        tareasPendientes = new ArrayList<>();
    }

    public void agregarTarea(TareaMantenimiento tarea) {
        tareasPendientes.add(tarea);
    }

    public List<TareaMantenimiento> getTareasPendientes() {
        return tareasPendientes;
    }
}

// Clase para representar una cámara de seguridad
class Camara {
    private String ubicacion;

    public Camara(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public void grabar() {
        System.out.println("La cámara en " + ubicacion + " está grabando.");
    }
}

// Clase para representar un sensor de movimiento
class SensorMovimiento {
    private String ubicacion;

    public SensorMovimiento(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public void detectarMovimiento() {
        System.out.println("El sensor de movimiento en " + ubicacion + " detectó movimiento.");
    }
}

// Clase para el sistema de seguridad
class SistemaSeguridad {
    private List<Camara> camaras;
    private List<SensorMovimiento> sensoresMovimiento;

    public SistemaSeguridad() {
        camaras = new ArrayList<>();
        sensoresMovimiento = new ArrayList<>();
    }

    public void agregarCamara(Camara camara) {
        camaras.add(camara);
    }

    public void agregarSensorMovimiento(SensorMovimiento sensor) {
        sensoresMovimiento.add(sensor);
    }
}

// Clase principal que contiene el método main
public class Main {
    public static void main(String[] args) {
        // Creamos instancias de tareas de mantenimiento
        TareaMantenimiento tarea1 = new TareaMantenimiento("Reparar cerca del león", false);
        TareaMantenimiento tarea2 = new TareaMantenimiento("Revisión de sistemas de agua", true);

        // Creamos una instancia del sistema de mantenimiento
        SistemaMantenimiento sistemaMantenimiento = new SistemaMantenimiento();
        sistemaMantenimiento.agregarTarea(tarea1);
        sistemaMantenimiento.agregarTarea(tarea2);

        // Creamos instancias de cámaras y sensores de movimiento
        Camara camara1 = new Camara("Entrada principal");
        Camara camara2 = new Camara("Área de los elefantes");

        SensorMovimiento sensor1 = new SensorMovimiento("Entrada principal");
        SensorMovimiento sensor2 = new SensorMovimiento("Área de los leones");

        // Creamos una instancia del sistema de seguridad
        SistemaSeguridad sistemaSeguridad = new SistemaSeguridad();
        sistemaSeguridad.agregarCamara(camara1);
        sistemaSeguridad.agregarCamara(camara2);
        sistemaSeguridad.agregarSensorMovimiento(sensor1);
        sistemaSeguridad.agregarSensorMovimiento(sensor2);

        // Simulamos algunas acciones
        System.out.println("Tareas de mantenimiento pendientes:");
        for (TareaMantenimiento tarea : sistemaMantenimiento.getTareasPendientes()) {
            System.out.println("- " + tarea.getDescripcion() + (tarea.esUrgente() ? " (Urgente)" : ""));
        }

        // Simulamos movimiento y grabación
        sensor1.detectarMovimiento();
        camara2.grabar();
    }
}
