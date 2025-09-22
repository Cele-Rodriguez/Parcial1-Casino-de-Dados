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
public class JugadorCasino extends Jugador {
    
     public JugadorCasino(String apodo, int dineroInicial) {
        super(apodo, dineroInicial);
    }
     
         //Poliformismo
    @Override
    public int calcularApuesta() {
        return (int) Math.round(getDinero() * 0.2); // apuesta un 20% de su dinero actual.
    }

    @Override
    public String obtenerTipoJugador() {
        return "Experto";
    }
}