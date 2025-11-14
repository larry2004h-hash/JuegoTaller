package Taller.pkPersonajes;

public class Observador extends Personaje {

    public Observador() {
        super("Observador");
    }

    @Override
    public void accionEspecial() {
        System.out.println("El observador vigila atentamente...");
    }
}
