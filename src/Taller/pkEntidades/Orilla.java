package Taller.pkEntidades;

import java.util.ArrayList;
import java.util.List;
import Taller.pkPersonajes.Personaje;

public class Orilla {

    private String nombre;
    private List<Personaje> personajes;

    public Orilla(String nombre) {
        this.nombre = nombre;
        personajes = new ArrayList<>();
    }

    public void agregar(Personaje p) {
        personajes.add(p);
    }

    public void remover(Personaje p) {
        personajes.remove(p);
    }

    public List<Personaje> getPersonajes() {
        return personajes;
    }

    public String getNombres() {
        if (personajes.isEmpty()) return "—";
        String str = "";
        for (Personaje p : personajes) str += p.getNombre() + " ";
        return str.trim();
    }
}
