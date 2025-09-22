/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package desafio3;
import desafio3.jugador.Jugador;
import desafio3.jugador.tipos.*;

import java.util.*;
/**
 *
 * @author Cele
 */
public class Casino {
    private final List<Jugador> jugadores = new ArrayList<>();
    private final JuegoDados juego = new JuegoDados();
    private static final int RONDAS_MAX = 3;
    private static final int DINERO_INICIAL = 500;

    public void agregarJugador(Jugador j) { jugadores.add(j); }

    public Jugador crearJugador(String apodo, int tipo) {
        if (tipo == 1) return new JugadorNovato(apodo, DINERO_INICIAL);
        if (tipo == 2) return new JugadorExperto(apodo, DINERO_INICIAL);
        if (tipo == 2) return new JugadorVip(apodo, DINERO_INICIAL);
        return null;
    }

    public void jugar() {
        for (int ronda = 1; ronda <= RONDAS_MAX; ronda++) {
            System.out.println("\nRonda " + ronda);
            JuegoDados.Resultado res = juego.jugarRonda(jugadores);

            for (Jugador j : jugadores) {
                System.out.println(j.getApodoConTipo() + 
                    " | Apuesta: $" + res.apuestas.get(j) +
                    " | Dados: " + res.sumas.get(j) +
                    " | Dinero: $" + j.getDinero());
            }

            if (!res.ganadores.isEmpty()) {
                System.out.print("Ganador(es): ");
                for (Jugador g : res.ganadores) System.out.print(g.getApodo() + " ");
                System.out.println();
            }

            if (jugadores.stream().anyMatch(j -> j.getDinero() <= 0)) break;
        }
    }
}
