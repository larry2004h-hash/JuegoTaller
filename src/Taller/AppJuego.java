package Taller;

import java.util.Scanner;
import Taller.pkEntidades.*;
import Taller.pkPersonajes.*;

public class AppJuego {

    private Orilla izquierda = new Orilla("izquierda");
    private Orilla derecha = new Orilla("derecha");
    private Barco barco = new Barco("izquierda");

    private Caperucita caperucita = new Caperucita();
    private Lobo lobo = new Lobo();
    private Uva uva = new Uva();
    private Observador obs = new Observador();

    Scanner sc = new Scanner(System.in);

    public AppJuego() {
        izquierda.agregar(caperucita);
        izquierda.agregar(lobo);
        izquierda.agregar(uva);
        izquierda.agregar(obs);
    }

    public void iniciarJuego() {
        System.out.println("=== JUEGO INICIADO ===");

        while (true) {

            mostrarEstado();

            if (verificarPerder()) {
                System.out.println("❌ Perdiste.");
                break;
            }

            if (verificarGanar()) {
                System.out.println("🎉 ¡GANASTE!");
                break;
            }

            System.out.println("""
1. Subir personaje al barco
2. Bajar personaje del barco
3. Cruzar el río
Seleccione: """);

            int op = sc.nextInt();
            sc.nextLine();

            switch (op) {
                case 1 -> subir();
                case 2 -> bajar();
                case 3 -> barco.cruzar();
                default -> System.out.println("Opción inválida");
            }
        }
    }

    private void subir() {
        Orilla actual = barco.getUbicacion().equals("izquierda") ? izquierda : derecha;

        System.out.println("Personajes en esta orilla: " + actual.getNombres());
        System.out.print("¿A quién subir? ");
        String nombre = sc.nextLine();

        Personaje p = buscar(nombre, actual);
        if (p == null) {
            System.out.println("No existe ese personaje aquí.");
            return;
        }

        if (barco.subir(p)) {
            actual.remover(p);
        }
    }

    private void bajar() {
        if (barco.getPasajeros().isEmpty()) {
            System.out.println("No hay nadie en el barco.");
            return;
        }

        System.out.println("En el barco: " + barco.getNombrePersonaje());
        System.out.print("¿A quién bajar? ");
        String nombre = sc.nextLine();

        Personaje p = buscar(nombre, barco);
        if (p == null) {
            System.out.println("No está en el barco.");
            return;
        }

        barco.bajar(p);

        if (barco.getUbicacion().equals("izquierda")) izquierda.agregar(p);
        else derecha.agregar(p);
    }

    private Personaje buscar(String nombre, Orilla o) {
        return o.getPersonajes().stream()
                .filter(p -> p.getNombre().equalsIgnoreCase(nombre))
                .findFirst().orElse(null);
    }

    private Personaje buscar(String nombre, Barco b) {
        return b.getPasajeros().stream()
                .filter(p -> p.getNombre().equalsIgnoreCase(nombre))
                .findFirst().orElse(null);
    }

    private boolean verificarPerder() {
        // Lobo come a caperucita si están solos en una orilla
        if (estanSolos(izquierda, lobo, caperucita)) return true;
        if (estanSolos(derecha, lobo, caperucita)) return true;
        return false;
    }

    private boolean estanSolos(Orilla o, Personaje a, Personaje b) {
        return o.getPersonajes().contains(a)
                && o.getPersonajes().contains(b)
                && o.getPersonajes().size() == 2;
    }

    private boolean verificarGanar() {
        return derecha.getPersonajes().size() == 4;
    }

    private void mostrarEstado() {
        System.out.println("\n-----------------------------");
        System.out.println("Orilla izquierda: " + izquierda.getNombres());
        System.out.println("Orilla derecha:   " + derecha.getNombres());
        System.out.println("En el barco:      " + barco.getNombrePersonaje());
        System.out.println("Ubic. del barco:  " + barco.getUbicacion());
        System.out.println("-----------------------------\n");
    }
}
