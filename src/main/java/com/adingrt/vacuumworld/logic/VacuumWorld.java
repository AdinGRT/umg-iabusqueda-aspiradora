package com.adingrt.vacuumworld.logic;

/**
 *
 * @author Adin Rubio
 */
public class VacuumWorld {
    private Object[][] terreno;

    public VacuumWorld() {
        this.terreno = new Object[2][2];
    }
    
    public Object[][] getTerreno() {
        return terreno;
    }

    public void setTerreno(Object[][] terreno) {
        this.terreno = terreno;
    }
    
}
