/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package desafio3.jugador;

/**
 *
 * @author Cele
 */
public abstract class Jugador {
    private final String apodo;
    private int dinero;
    private int partidasGanadas;
    
    // Constructor
    public Jugador(String apodo, int dineroInicial) {
        this.apodo = apodo;
        this.dinero = dineroInicial; 
        this.partidasGanadas = 0;
    }
    
    // Getters
    public String getApodo() { return apodo; }
    public int getDinero() { return dinero; }
    public int getPartidasGanadas() { return partidasGanadas; }

     // Setters 
    public void setDinero(int dinero) {
        if (dinero >= 0) {
            this.dinero = dinero;
        }
    }
   
    // Metodos communes 
     public void ganar(int cantidad) {
        if (cantidad > 0) {
            dinero += cantidad;
        }
    }
     
    public void perder(int cantidad) {
        if (cantidad > 0) {
            dinero -= cantidad;
           if (dinero < 0) {
                dinero = 0; 
            }
        }
    }
    
    //Métodos abstractos que deben implementar las subclases
    public abstract int calcularApuesta();

    public abstract String obtenerTipoJugador();
    
    
    
   //-------------------------------------------------
    public void sumarVictoria() { partidasGanadas++; }
   // Método para mostrar nombre + tipo
    public String getApodoConTipo() {
        return apodo + " (" + obtenerTipoJugador() + ")";
    }
}
