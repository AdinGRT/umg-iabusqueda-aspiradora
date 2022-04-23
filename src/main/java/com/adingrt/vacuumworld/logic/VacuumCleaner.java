package com.adingrt.vacuumworld.logic;

import com.adingrt.vacuumworld.exceptions.InvalidPositionException;

/**
 * @author Adin Rubio
 */
public class VacuumCleaner {
    private String id;
    private Coordinates currentPosition;
    private VacuumWorld world;
    
    public VacuumCleaner() {
    }

    public VacuumCleaner(String id, Coordinates currentPosition) {
        this.id = id;
        this.currentPosition = currentPosition;
    }

    public void assignWorld(VacuumWorld world) {
        this.world = world;
    }
    
    public void suckdirt() {
        this.world.setDirty(currentPosition, false);
    }
    
    public void move(char direction) {
        int x = this.currentPosition.getX();
        int y = this.currentPosition.getY();
        switch (direction) {
            case 'u':
                if(x > 0) this.currentPosition.setX(x-1);
                else throw new InvalidPositionException("Posicion no valida!");
                break;
            case 'd':
                if (x < this.world.getWorld().length-1) this.currentPosition.setX(x+1);
                else throw new InvalidPositionException("Posicion no valida!");
                break;
            case 'l':
                if (y > 0) this.currentPosition.setY(y-1);
                else throw new InvalidPositionException("Posicion no valida!");
                break;
            case 'r':
                if (y < this.world.getWorld()[0].length-1) this.currentPosition.setY(y+1);
                else throw new InvalidPositionException("Posicion no valida!");
                break;
            default:
                throw new InvalidPositionException("Direccion no valida!");
        }
    }
}
