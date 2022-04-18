package com.adingrt.vacuumworld.testconsole;

import com.adingrt.vacuumworld.logic.VacuumCleaner;
import com.adingrt.vacuumworld.logic.VacuumWorld;

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
        
        
        
        
         
        VacuumWorld mundo = new VacuumWorld();
        VacuumCleaner aspiradora = new VacuumCleaner("ASPIRADORA 1", 0);
        
        mundo.getWorld()[0][0] = aspiradora;
        mundo.getWorld()[0][1] = "vacio";
        mundo.getWorld()[1][0] = "sucio";
        mundo.getWorld()[1][1] = "sucio";
        
        for (int i = 0; i < mundo.getWorld().length; i++) {
            for (int j = 0; j < mundo.getWorld().length; j++) {
                System.out.println(mundo.getWorld()[i][j].toString());
            }
        }
        
        
        
    }
}
