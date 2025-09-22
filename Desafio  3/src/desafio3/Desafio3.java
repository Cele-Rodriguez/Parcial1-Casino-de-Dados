/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package desafio3;

/**
 *
 * @author Cele
 */
import desafio3.jugador.Jugador;
import java.util.Scanner;

public class Desafio3 {

    /**
     * @param args the command line arguments
     */
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        Casino casino = new Casino();

        System.out.println(" ¡Bienvenidos al Casino de Dados! ");

        // Crear jugadores
        int n;
        do {
            System.out.print("¿Cuántos jugadores participarán? (2-4): ");
            n = sc.nextInt();
            sc.nextLine();
        } while (n < 2);

        for (int i = 1; i <= n; i++) {
            System.out.print("Apodo del jugador " + i + ": ");
            String nombre = sc.nextLine();

            System.out.print("Tipo (1=Novato, 2=Experto, 3=VIP): ");
            int tipo = sc.nextInt();
            sc.nextLine();

            Jugador jugador = casino.crearJugador(nombre, tipo);
            casino.agregarJugador(jugador);
        }

        casino.jugar();

        sc.close();
    // TODO code application logic here
    }
    
}
