package Taller.pkEntidades;

import java.util.ArrayList;
import java.util.List;
import Taller.pkPersonajes.Personaje;

public class Barco {

    private List<Personaje> pasajeros;
    private String ubicacion; // izquierda / derecha

    public Barco(String inicial) {
        ubicacion = inicial;
        pasajeros = new ArrayList<>();
    }

    public String getUbicacion() { return ubicacion; }
    public List<Personaje> getPasajeros() { return pasajeros; }

    public boolean subir(Personaje p) {
        if (pasajeros.size() >= 2) {
            System.out.println("⚠ El barco ya tiene 2 pasajeros.");
            return false;
        }
        pasajeros.add(p);
        return true;
    }

    public void bajar(Personaje p) {
        pasajeros.remove(p);
    }

    public void cruzar() {
        if (pasajeros.isEmpty()) {
            System.out.println("⚠ No puedes cruzar el río sin pasajeros.");
            return;
        }
        ubicacion = ubicacion.equals("izquierda") ? "derecha" : "izquierda";
        System.out.println("🌊 El barco cruzó a la " + ubicacion);
    }

    public String getNombrePersonaje() {
        if (pasajeros.isEmpty()) return "—";
        String s = "";
        for (Personaje p : pasajeros) s += p.getNombre() + " ";
        return s.trim();
    }
}
