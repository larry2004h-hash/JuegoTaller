package Taller.pkPersonajes;

public class Uva extends Personaje {

    public Uva() {
        super("Uva");
    }

    @Override
    public void accionEspecial() {
        System.out.println("Las uvas no hacen nada...");
    }
}

