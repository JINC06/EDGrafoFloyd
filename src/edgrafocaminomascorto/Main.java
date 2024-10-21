/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edgrafocaminomascorto;

/**
 *
 * @author julio.nava
 */
public class Main {
    
    public static void main(String args[]) {
        
        long matrizA[][] = {
            {0, 3, 4, 999999999, 8, 999999999},
            {999999999, 0, 999999999, 999999999, 5, 999999999},
            {999999999, 999999999, 0, 999999999, 3, 999999999},
            {999999999, 999999999, 999999999, 0, 999999999, 999999999},
            {999999999, 999999999, 999999999, 7, 0, 3},
            {999999999, 999999999, 999999999, 2, 999999999, 0}
        };
        
        CaminosCortos ruta = new CaminosCortos();
        System.out.println(ruta.algoritmoFloyd(matrizA));
        
    }
    
}
