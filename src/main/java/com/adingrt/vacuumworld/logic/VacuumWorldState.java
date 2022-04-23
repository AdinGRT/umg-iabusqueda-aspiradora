package com.adingrt.vacuumworld.logic;

/**
 *
 * @author Adin Rubio
 */
public class VacuumWorldState {
    private VacuumCleaner vacuum;
    private VacuumWorld world;

    public VacuumWorldState(VacuumCleaner vacuum, VacuumWorld world) {
        this.vacuum = vacuum;
        this.world = world;
    }
    
}
