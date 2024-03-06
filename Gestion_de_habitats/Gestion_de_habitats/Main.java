public class Main {
    public static void main(String[] args) {

        HabitatAcuatico acuario = new HabitatAcuatico("Acuario");
        HabitatTerrestre bosque = new HabitatTerrestre("Bosque");
        HabitatAviario jaula = new HabitatAviario("Jaula de pájaros");

        acuario.cambiarTemperatura(25);
        acuario.cambiarHumedad(80);
        acuario.cambiarLimpieza(90);

        bosque.cambiarTemperatura(20);
        bosque.cambiarHumedad(70);
        bosque.cambiarLimpieza(85);

        jaula.cambiarTemperatura(22);
        jaula.cambiarHumedad(60);
        jaula.cambiarLimpieza(95);

        acuario.monitorear();
        bosque.monitorear();
        jaula.monitorear();
    }

    static class Habitat {
        String nombre;
        double temperatura;
        double humedad;
        double limpieza;

        public Habitat(String nombre) {
            this.nombre = nombre;
            this.temperatura = 0;
            this.humedad = 0;
            this.limpieza = 0;
        }

        public void monitorear() {
            System.out.println("Monitoreando " + nombre + ":");
            System.out.println("Temperatura: " + temperatura);
            System.out.println("Humedad: " + humedad);
            System.out.println("Limpieza: " + limpieza);
        }
    }

    static class HabitatAcuatico extends Habitat {
        public HabitatAcuatico(String nombre) {
            super(nombre);
        }

        public void cambiarTemperatura(double temperatura) {
            this.temperatura = temperatura;
        }

        public void cambiarHumedad(double humedad) {
            this.humedad = humedad;
        }

        public void cambiarLimpieza(double limpieza) {
            this.limpieza = limpieza;
        }
    }

    static class HabitatTerrestre extends Habitat {
        public HabitatTerrestre(String nombre) {
            super(nombre);
        }

        public void cambiarTemperatura(double temperatura) {
            this.temperatura = temperatura;
        }

        public void cambiarHumedad(double humedad) {
            this.humedad = humedad;
        }

        public void cambiarLimpieza(double limpieza) {
            this.limpieza = limpieza;
        }
    }

    static class HabitatAviario extends Habitat {
        public HabitatAviario(String nombre) {
            super(nombre);
        }

        public void cambiarTemperatura(double temperatura) {
            this.temperatura = temperatura;
        }

        public void cambiarHumedad(double humedad) {
            this.humedad = humedad;
        }

        public void cambiarLimpieza(double limpieza) {
            this.limpieza = limpieza;
        }
    }
}