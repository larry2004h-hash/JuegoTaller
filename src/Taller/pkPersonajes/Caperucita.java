package Taller.pkPersonajes;

public class Caperucita extends Personaje {

    public Caperucita() {
        super("Caperucita");
    }

    @Override
    public void accionEspecial() {
        System.out.println("Caperucita canta mientras viaja...");
    }
}
