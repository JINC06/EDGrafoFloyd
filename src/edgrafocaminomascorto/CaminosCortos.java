/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edgrafocaminomascorto;

/**
 *
 * @author julio.nava
 */
public class CaminosCortos {
    
    //Metodo para determinar todos los caminos Floyd
    public String algoritmoFloyd(long[][] mAdy) {
        int vertices = mAdy.length;
        long matrizAdyacencia[][] = mAdy;
        String caminos[][] = new String[vertices][vertices];
        String caminosAuxiliares[][] = new String[vertices][vertices];
        String caminoRecorrido = "", cadena = "", caminitos = "";
        int i, j, k;
        float temporal1, temporal2, temporal3, temporal4, minimo;
        
        //Inicializando las matrices caminos y caminosAuxiliares
        for(i = 0; i < vertices; i++){
            for(j = 0; j < vertices; j++){
                caminos[i][j] = "";
                caminosAuxiliares[i][j] = "";
            }
        }
        
        for(k = 0; k < vertices; k++) {
            for(i = 0; i < vertices; i++) {
                for(j = 0; j < vertices; j++) {
                    temporal1 = matrizAdyacencia[i][j];
                    temporal2 = matrizAdyacencia[i][k];
                    temporal3 = matrizAdyacencia[k][j];
                    temporal4 = temporal2 + temporal3;
                    //Encontrando al Minimo
                    minimo = Math.min(temporal1, temporal4);
                    if(temporal1 != temporal4) {
                        if(minimo == temporal4) {
                            caminoRecorrido = "";
                            caminosAuxiliares[i][j] = k + "";
                            caminos[i][j] = caminosR(i, k, caminosAuxiliares, caminoRecorrido) + (k + 1);
                        }
                    }
                    matrizAdyacencia[i][j] = (long) minimo;
                }
            }
        }
        
        //Agregando el camino minimo a cadena
        for(i = 0; i < vertices; i++){
            for(j = 0; j < vertices; j++){
                cadena = cadena + "[" + matrizAdyacencia[i][j] + "]";
            }
            cadena = cadena + "\n";
        }
        
        ////////////////////////////////////////
        for(i = 0; i < vertices; i++){
            for(j = 0; j < vertices; j++){
                if(matrizAdyacencia[i][j] != 1000000000){
                    if(i != j) {
                        if(caminos[i][j].equals("")) {
                            caminitos += "De (" + (i + 1)+ "--->" + (j + 1) + ") Irse Por ...(" + (i + 1) + ", " + (j + 1) + ")\n";
                        }else{
                            caminitos += "De (" + (i + 1)+ "--->" + (j + 1) + ") Irse Por ...(" + (i + 1) + ", " + caminos[i][j] + ", " + ( j + 1) + ")\n";
                        }
                    }
                }
            }
        }
        
        return "La Matriz de Caminos Más Cortos Entre Los Diferentes Vértices es: \n" + cadena + 
                "\nLos Diferentes Caminos Más Cortos Entre Vértices son:\n" + caminitos;
    }
    
    public String caminosR(int i, int k, String[][] caminosAuxiliares, String caminoRecorrido) {
        if(caminosAuxiliares[i][k].equals("")) {
            return "";
        }else{
            //Recursividad 
            caminoRecorrido += caminosR(i, Integer.parseInt(caminosAuxiliares[i][k].toString()), 
                    caminosAuxiliares, 
                    caminoRecorrido) + (Integer.parseInt(caminosAuxiliares[i][k].toString()) + 1) + ", ";
            return caminoRecorrido;
        }
    }
    
}
