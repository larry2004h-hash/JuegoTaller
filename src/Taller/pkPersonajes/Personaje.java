package Taller.pkPersonajes;

public abstract class Personaje {

    protected String nombre;

    public Personaje(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public abstract void accionEspecial();
}
