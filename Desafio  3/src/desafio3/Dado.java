/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package desafio3;
import java.util.Random;
/**
 *
 * @author Cele
 */
public class Dado {
      Random random = new Random();
      
    public int tirar () {
  
        int dado = random.nextInt(6) + 1;
       
        return dado;
    }
        
        
}
