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
public class JuegoDados {
    
    private final Dado d1 = new Dado();
    private final Dado d2 = new Dado();
    private final Set<Jugador> vipRerollUsado = new HashSet<>();
    
     public Resultado jugarRonda(List<Jugador> jugadores) {
        Map<Jugador,Integer> apuestas = new HashMap<>();
        Map<Jugador,Integer> sumas = new HashMap<>();
        int pozo = 0;

        // 1) Apuestas
        for (Jugador j : jugadores) {
            int ap = Math.min(j.calcularApuesta(), j.getDinero());
            j.perder(ap);
            apuestas.put(j, ap);
            pozo += ap;
        }

        // 2) Tiradas
        for (Jugador j : jugadores) {
            int ap = apuestas.get(j);
            if (ap == 0) { sumas.put(j, 0); continue; }

            int s = d1.tirar() + d2.tirar();
            if (j instanceof JugadorVip && !vipRerollUsado.contains(j) && s <= 6) {
                s = d1.tirar() + d2.tirar(); // re-roll una vez
                vipRerollUsado.add(j);
            }
            sumas.put(j, s);
        }

        // 3) Determinar ganadores
        int max = sumas.values().stream().max(Integer::compareTo).orElse(0);
        List<Jugador> ganadores = new ArrayList<>();
        for (Jugador j : jugadores) if (sumas.get(j) == max && max > 0) ganadores.add(j);

        // 4) Reparto del pozo
        if (!ganadores.isEmpty() && pozo > 0) {
            int premio = pozo / ganadores.size();
            for (Jugador g : ganadores) {
                g.ganar(premio);
                g.sumarVictoria();
            }
        }

        return new Resultado(apuestas, sumas, ganadores, pozo);
    }

    // Clase resultado muy simple
    public static class Resultado {
        public Map<Jugador,Integer> apuestas, sumas;
        public List<Jugador> ganadores;
        public int pozo;
        public Resultado(Map<Jugador,Integer> a, Map<Jugador,Integer> s, List<Jugador> g, int p) {
            this.apuestas=a; this.sumas=s; this.ganadores=g; this.pozo=p;
        }
    }

}
