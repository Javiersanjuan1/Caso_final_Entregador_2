import java.util.*;


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


class Camara {
    private String ubicacion;

    public Camara(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public void grabar() {
        System.out.println("La cámara en " + ubicacion + " está grabando.");
    }
}


class SensorMovimiento {
    private String ubicacion;

    public SensorMovimiento(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public void detectarMovimiento() {
        System.out.println("El sensor de movimiento en " + ubicacion + " detectó movimiento.");
    }
}


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


public class Main {
    public static void main(String[] args) {

        TareaMantenimiento tarea1 = new TareaMantenimiento("Reparar cerca del león", false);
        TareaMantenimiento tarea2 = new TareaMantenimiento("Revisión de sistemas de agua", true);

        SistemaMantenimiento sistemaMantenimiento = new SistemaMantenimiento();
        sistemaMantenimiento.agregarTarea(tarea1);
        sistemaMantenimiento.agregarTarea(tarea2);

        Camara camara1 = new Camara("Entrada principal");
        Camara camara2 = new Camara("Área de los elefantes");

        SensorMovimiento sensor1 = new SensorMovimiento("Entrada principal");
        SensorMovimiento sensor2 = new SensorMovimiento("Área de los leones");

        SistemaSeguridad sistemaSeguridad = new SistemaSeguridad();
        sistemaSeguridad.agregarCamara(camara1);
        sistemaSeguridad.agregarCamara(camara2);
        sistemaSeguridad.agregarSensorMovimiento(sensor1);
        sistemaSeguridad.agregarSensorMovimiento(sensor2);

        System.out.println("Tareas de mantenimiento pendientes:");
        for (TareaMantenimiento tarea : sistemaMantenimiento.getTareasPendientes()) {
            System.out.println("- " + tarea.getDescripcion() + (tarea.esUrgente() ? " (Urgente)" : ""));
        }

        sensor1.detectarMovimiento();
        camara2.grabar();
    }
}
