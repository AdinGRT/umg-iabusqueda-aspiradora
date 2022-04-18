package com.adingrt.vacuumworld.logic;

/**
 *
 * @author Adin Rubio
 */
public class VacuumWorld<E> {
    private E[][] world;

    public VacuumWorld() {
    }

    public VacuumWorld(E[][] world) {
        this.world = world;
    }

    public E[][] getWorld() {
        return world;
    }

    public void setWorld(E[][] world) {
        this.world = world;
    }
    
}
