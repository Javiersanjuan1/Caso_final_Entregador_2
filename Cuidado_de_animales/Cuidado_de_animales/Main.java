class Animal {
    protected String nombre;
    protected int edad;
    protected float peso;

    public Animal(String nombre, int edad, float peso) {
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
    }

    public void alimentar() {
        System.out.println("Alimentando a " + nombre);
    }

    public void revisarSalud() {
        System.out.println("Revisando salud de " + nombre);
    }

    public void comportamiento() {
        System.out.println("Observando el comportamiento de " + nombre);
    }
}

class Perro extends Animal {
    private String raza;

    public Perro(String nombre, int edad, float peso, String raza) {
        super(nombre, edad, peso);
        this.raza = raza;
    }

    @Override
    public void alimentar() {
        super.alimentar();
        System.out.println(nombre + " está comiendo comida para perros");
    }

    @Override
    public void revisarSalud() {
        super.revisarSalud();
        System.out.println(nombre + " tiene una salud excelente");
    }

    @Override
    public void comportamiento() {
        super.comportamiento();
        System.out.println(nombre + " está ladrando y moviendo la cola");
    }
}

class Gato extends Animal {
    private String color;

    public Gato(String nombre, int edad, float peso, String color) {
        super(nombre, edad, peso);
        this.color = color;
    }

    @Override
    public void alimentar() {
        super.alimentar();
        System.out.println(nombre + " está comiendo comida para gatos");
    }

    @Override
    public void revisarSalud() {
        super.revisarSalud();
        System.out.println(nombre + " tiene un buen estado de salud");
    }

    @Override
    public void comportamiento() {
        super.comportamiento();
        System.out.println(nombre + " está ronroneando y jugando con un juguete");
    }
}

public class Main {
    public static void main(String[] args) {
        Perro miPerro = new Perro("Max", 3, 10.5f, "Labrador");
        miPerro.alimentar();
        miPerro.revisarSalud();
        miPerro.comportamiento();

        Gato miGato = new Gato("Whiskers", 2, 5.0f, "Blanco");
        miGato.alimentar();
        miGato.revisarSalud();
        miGato.comportamiento();
    }
}