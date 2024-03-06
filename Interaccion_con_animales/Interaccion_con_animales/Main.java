
class Animal {
    protected String nombre;
    protected String habitat;

    public Animal(String nombre, String habitat) {
        this.nombre = nombre;
        this.habitat = habitat;
    }

    public void obtenerInformacion() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Habitat: " + habitat);
    }
}


class Ave extends Animal {
    public Ave(String nombre, String habitat) {
        super(nombre, habitat);
    }
}

class Mamifero extends Animal {
    public Mamifero(String nombre, String habitat) {
        super(nombre, habitat);
    }
}


class QuioscoInteractivo {
    public void mostrarInformacion(Animal animal) {
        System.out.println("Información sobre el animal:");
        animal.obtenerInformacion();
    }
}


public class Main {
    public static void main(String[] args) {
        Ave aguila = new Ave("Águila", "Montañas");
        Mamifero tigre = new Mamifero("Tigre", "Selva");

        QuioscoInteractivo quiosco = new QuioscoInteractivo();

        quiosco.mostrarInformacion(aguila);
        quiosco.mostrarInformacion(tigre);
    }
}
