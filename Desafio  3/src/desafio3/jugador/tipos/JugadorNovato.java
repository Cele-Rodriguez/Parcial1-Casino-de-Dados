/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package desafio3.jugador.tipos;

import desafio3.jugador.Jugador;

/**
 *
 * @author Cele
 */
public class JugadorNovato extends Jugador{

    public JugadorNovato(String apodo, int dineroInicial) {
        super(apodo, dineroInicial);
    }

    //Poliformismo
    @Override
    public int calcularApuesta() {
        return 50; // siempre apuesta 50 
    }

    @Override
    public String obtenerTipoJugador() {
        return "Novato";
    }
    
}
