package com.adingrt.vacuumworld.logic;

/**
 *
 * @author Adin Rubio
 */
public class VacuumWorld {
    private Boolean[][] world;

    public VacuumWorld() {
    }

    public VacuumWorld(Boolean[][] world) {
        this.world = world;
    }
    
    public Boolean[][] getWorld() {
        return world;
    }

    public void setWorld(Boolean[][] world) {
        this.world = world;
    }

    public boolean isDirty(Coordinates coord) {
        return this.world[coord.getX()][coord.getY()];
    }

    public void setDirty(Coordinates coord, boolean isDirty) {
        this.world[coord.getX()][coord.getY()] = isDirty;
    }
    
}
