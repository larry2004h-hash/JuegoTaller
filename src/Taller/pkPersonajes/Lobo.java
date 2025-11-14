package Taller.pkPersonajes;

public class Lobo extends Personaje {

    public Lobo() {
        super("Lobo");
    }

    @Override
    public void accionEspecial() {
        System.out.println("El lobo gruñe...");
    }
}
