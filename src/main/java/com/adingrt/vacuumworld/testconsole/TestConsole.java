package com.adingrt.vacuumworld.testconsole;

import com.adingrt.vacuumworld.logic.Aspiradora;
import com.adingrt.vacuumworld.logic.MundoAspiradora;

/**
 *
 * @author Adin Rubio
 */
public class TestConsole {
    public static void main(String[] args) {
        
        //Aspiradora 0 = izquierda; 1 = derecha
        //Estado 0 = sucio; 1 = limpio
        int[] estadoInicial = {0,0,0};
        
        int[] estadoFinal1 = {0,1,1};
        int[] estadoFinal2 = {1,1,1};
        
        
        
        
         
        MundoAspiradora mundo = new MundoAspiradora();
        Aspiradora aspiradora = new Aspiradora("ASPIRADORA 1", 0);
        
        mundo.getTerreno()[0][0] = aspiradora;
        mundo.getTerreno()[0][1] = "vacio";
        mundo.getTerreno()[1][0] = "sucio";
        mundo.getTerreno()[1][1] = "sucio";
        
        for (int i = 0; i < mundo.getTerreno().length; i++) {
            for (int j = 0; j < mundo.getTerreno().length; j++) {
                System.out.println(mundo.getTerreno()[i][j].toString());
            }
        }
        
        
        
    }
}
